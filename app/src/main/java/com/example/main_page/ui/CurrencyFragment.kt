package com.example.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.common.base_ui.BaseFragment
import com.example.main_page.model.currency_info.CurrencyInfo
import com.example.main_page.ui.adapter.CurrencyAdapter
import com.example.thebestcurrency.R
import com.example.thebestcurrency.databinding.FragmentCurrencyMainPageBinding
import org.koin.android.ext.android.inject
import timber.log.Timber


private const val APIKEY = "Ujqc2SLtPZv6C4WcyTMrPHIfbRrjnweCUmAm3JWn"

class CurrencyFragment: BaseFragment(R.layout.fragment_currency_main_page) {

    private val viewModel: CurrencyViewModel by inject()
    private lateinit var binding: FragmentCurrencyMainPageBinding

    companion object {
        fun newInstance() = CurrencyFragment
    }


    private val adapter: CurrencyAdapter = CurrencyAdapter()


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
        with(binding) {
            recyclerView.adapter = adapter
            viewModel.getCurrencyData(apikey = APIKEY)
            observe(viewModel.currencyInfoFlow) { currencyData ->
                showData(currencyData)
            }

            observe(viewModel.isLoading) { isLoading ->
                progressCurrency.isVisible = isLoading
            }
        }
    }

    fun showData(data: List<CurrencyInfo?>?) {
        Timber.d("______showData: $data")
        data?.let { adapter.setData(it) }
    }
}