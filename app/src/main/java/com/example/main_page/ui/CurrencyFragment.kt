package com.example.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.doOnAttach
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.base_ui.BaseFragment
import com.example.convert_currencies.ui.CurrencyConvertFragment
import com.example.login_registration_ui.LoginFragment
import com.example.main_page.model.currency_info.CurrencyInfo
import com.example.main_page.ui.adapter.CurrencyAdapter
import com.example.thebestcurrency.R
import com.example.thebestcurrency.databinding.FragmentCurrencyMainPageBinding
import com.example.utils.extensions.replace
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import timber.log.Timber


private const val APIKEY = "Ujqc2SLtPZv6C4WcyTMrPHIfbRrjnweCUmAm3JWn"

class CurrencyFragment : BaseFragment(R.layout.fragment_currency_main_page),
AdapterView.OnItemSelectedListener{

    private val viewModel: CurrencyViewModel by inject()
    private lateinit var binding: FragmentCurrencyMainPageBinding
    private val auth = FirebaseAuth.getInstance()
    private var baseCurrency = "AUD"
    private val baseCurrencyAdapter by lazy {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.currencies,
            R.layout.item_currency_spinner
        )
    }
    companion object {
        fun newInstance() = CurrencyFragment()
    }


    private val adapter: CurrencyAdapter = CurrencyAdapter()

    private val layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyMainPageBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spinnerBaseCurrency.onItemSelectedListener = this

        with(binding) {
            var user = auth.currentUser
            if (user == null) replace(LoginFragment(), R.id.fragmentContainer)

            logoutTextView.setOnClickListener {
                 FirebaseAuth.getInstance().signOut()
                replace(LoginFragment(), R.id.fragmentContainer)
            }

            viewModel.getCurrencyData(apikey = APIKEY,baseCurrency = baseCurrency)

            binding.recyclerView.doOnAttach {
                binding.recyclerView.layoutManager = layoutManager
            }

            observe(viewModel.currencyInfoFlow) { currencyData ->
                currencyData?.let { adapter.setData(it) }
                }

            observe(viewModel.isLoading) { isLoading ->
                    progressCurrency.isVisible = isLoading
                }

            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
            adapter.onAttachedToRecyclerView(recyclerView)

            convertCurrencyBtn.setOnClickListener {
                replace(CurrencyConvertFragment.newInstance(), R.id.fragmentContainer)
            }

            baseCurrencyAdapter.setDropDownViewResource(R.layout.item_drop_down_list)

            if (spinnerBaseCurrency.adapter == null) spinnerBaseCurrency.adapter =
                baseCurrencyAdapter

        }
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        with(binding) {
            baseCurrency = spinnerBaseCurrency.selectedItem.toString()

            viewModel.getCurrencyData(apikey = APIKEY,baseCurrency = baseCurrency)
            Timber.d("BASECURRENCY ========= $baseCurrency")
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onDestroyView() {
        binding.recyclerView.layoutManager = null
        super.onDestroyView()
    }
}

