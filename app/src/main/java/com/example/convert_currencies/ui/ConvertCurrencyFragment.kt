package com.example.convert_currencies.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.example.common.base_ui.BaseFragment
import com.example.main_page.ui.CurrencyFragment
import com.example.thebestcurrency.R
import com.example.thebestcurrency.databinding.FragmentCurrencyConvertPageBinding
import com.example.utils.extensions.replace
import org.koin.android.ext.android.inject


private const val APIKEY = "Ujqc2SLtPZv6C4WcyTMrPHIfbRrjnweCUmAm3JWn"

class ConvertCurrencyFragment : BaseFragment(R.layout.fragment_currency_convert_page) {

    private val viewModel: ConvertCurrencyViewModel by inject()
    private lateinit var binding: FragmentCurrencyConvertPageBinding
    private val baseCurrencyAdapter by lazy {
        ArrayAdapter(
            requireContext(),
            R.layout.item_currency_convert,
            CurrencyEnum.values()
        )
    }
    private val secondaryCurrencyAdapter by lazy {
        ArrayAdapter(
            requireContext(),
            R.layout.item_currency_convert,
            CurrencyEnum.values()
        )
    }


    companion object {
        fun newInstance() = CurrencyConvertFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyConvertPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            if (spinnerBaseCurrency.adapter == null) spinnerBaseCurrency.adapter =
                baseCurrencyAdapter
            if (spinnerCurrencies.adapter == null) spinnerCurrencies.adapter =
                secondaryCurrencyAdapter

            setSpinnerListeners()

//            viewModel.getCurrencyConvertData(
//                apikey = APIKEY,
//                baseCurrency = baseCurrency,
//                currencies = currencies
//            )

//            observe(viewModel.currencyInfoFlow) { currencyData ->
//                currenciesName.text =
//                    viewModel.getName(currencyName = currencies, data = currencyData)
//                baseCurrencyName.text =
//                    viewModel.getName(currencyName = baseCurrency, data = currencyData)
//
//                currenciesRate = viewModel.getRate(currencies, currencyData)

                val firstEditText = baseCurrencyEditText.text.toString()
                val secondEditText = currenciesEditText.text.toString()

//                when (viewModel.checkEditTexts(firstEditText, secondEditText)) {
//                    1 -> {
//                        currenciesTextView.text =
//                            viewModel.setSecondCurrencyTV(baseCurrencyCount, currenciesRate)
//                        baseCurrencyTextView.text = baseCurrencyEditText.text
//                    }
//                    2 -> {
//                        baseCurrencyTextView.text =
//                            viewModel.setFirstCurrencyTV(currenciesCount, currenciesRate)
//                        currenciesTextView.text = currenciesEditText.text
//                    }
//                    3 -> {
//                        currenciesTextView.text =
//                            viewModel.setSecondCurrencyTV(baseCurrencyCount, currenciesRate)
//                        baseCurrencyTextView.text = "1"
//                    }
//                }
//            }

            observe(viewModel.isLoading) { isLoading ->
                progressCurrency.isVisible = isLoading
            }

//            baseCurrencyEditText.doAfterTextChanged {
//                if (it.isNullOrEmpty()) {
//                    baseCurrencyTextView.text = "1"
//                    currenciesCount = 1.0
//                } else {
//                    baseCurrencyCount = it.toString().toDouble()
//                }
//                currenciesTextView.text =
//                    viewModel.setSecondCurrencyTV(baseCurrencyCount, currenciesRate)
//                baseCurrencyTextView.text = baseCurrencyEditText.text
//                if (currenciesEditText.text.toString() != "") {
//                    currenciesEditText.setText("", TextView.BufferType.EDITABLE)
//                }
//            }
            baseCurrencyEditText.addTextChangedListener {
                viewModel.setBaseCurrencyAmount(it.toString())
            }

            currenciesEditText.addTextChangedListener {
                viewModel.setSecondaryCurrencyAmount(it.toString())
            }

            toolBarDetailPageTitle.setNavigationOnClickListener {
                replace(CurrencyFragment.newInstance(), R.id.fragmentContainer)
            }

//            currenciesEditText.doAfterTextChanged {
//                if (it.isNullOrEmpty()) {
//                    currenciesTextView.text = "1"
//                    baseCurrencyTextView.text = ""
//                    currenciesTextView.text = ""
//                } else {
//                    currenciesCount = it.toString().toDouble()
//                    baseCurrencyTextView.text =
//                        viewModel.setFirstCurrencyTV(currenciesCount, currenciesRate)
//                    currenciesTextView.text = currenciesEditText.text
//                }
//                baseCurrencyTextView.text =
//                    viewModel.setFirstCurrencyTV(currenciesCount, currenciesRate)
//                currenciesTextView.text = currenciesEditText.text
//                if (baseCurrencyEditText.text.toString() != "1") {
//                    baseCurrencyEditText.setText("1", TextView.BufferType.EDITABLE)
//                }
//            }

            baseCurrencyAdapter.setDropDownViewResource(R.layout.item_drop_down_list)
            secondaryCurrencyAdapter.setDropDownViewResource(R.layout.item_drop_down_list)

        }
    }

    private fun setSpinnerListeners() {
        with(binding) {
            spinnerBaseCurrency.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val baseCurrency = baseCurrencyAdapter.getItem(position)
                        viewModel.setBaseCurrency(baseCurrency)
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }
                }
            spinnerCurrencies.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val secondaryCurrency = secondaryCurrencyAdapter.getItem(position)
                        viewModel.setSecondaryCurrency(secondaryCurrency)

                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }
                }
        }
    }

}