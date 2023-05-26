package com.example.convert_currencies.ui


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.example.common.base_ui.BaseFragment
import com.example.convert_currencies.model.currency_info.CurrencyInfoData
import com.example.thebestcurrency.R
import com.example.thebestcurrency.databinding.FragmentCurrencyConvertPageBinding
import org.koin.android.ext.android.inject
import timber.log.Timber


private const val APIKEY = "Ujqc2SLtPZv6C4WcyTMrPHIfbRrjnweCUmAm3JWn"

class CurrencyConvertFragment : BaseFragment(R.layout.fragment_currency_convert_page),
    AdapterView.OnItemSelectedListener {

    private val viewModel: CurrencyViewModel by inject()
    private lateinit var binding: FragmentCurrencyConvertPageBinding
    private var baseCurrency = "AUD"
    private var currencies = "AUD"
    private var currenciesCount: Double = 1.0
    private var baseCurrencyCount: Double = 1.0
    private var currenciesRate: Double? = 0.0

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

        binding.spinnerBaseCurrency.onItemSelectedListener = this
        binding.spinnerCurrencies.onItemSelectedListener = this

        with(binding) {

            viewModel.getCurrencyConvertData(
                apikey = APIKEY,
                baseCurrency = baseCurrency,
                currencies = currencies
            )

            observe(viewModel.currencyInfoFlow) { currencyData ->
                currenciesName.text =
                    viewModel.getName(currencyName = currencies, data = currencyData)
                baseCurrencyName.text =
                    viewModel.getName(currencyName = baseCurrency, data = currencyData)

                currenciesRate = viewModel.getRate(currencies, currencyData)

                val firstEditText = baseCurrencyEditText.text.toString()
                val secondEditText = currenciesEditText.text.toString()

                when (viewModel.checkEditTexts(firstEditText, secondEditText)) {
                    1 -> {
                        currenciesTextView.text =
                            viewModel.setSecondCurrencyTV(baseCurrencyCount, currenciesRate)
                        baseCurrencyTextView.text = baseCurrencyEditText.text
                    }
                    2 -> {
                        baseCurrencyTextView.text =
                            viewModel.setFirstCurrencyTV(currenciesCount, currenciesRate)
                        currenciesTextView.text = currenciesEditText.text
                    }
                    3 -> {
                        currenciesTextView.text =
                            viewModel.setSecondCurrencyTV(baseCurrencyCount, currenciesRate)
                        baseCurrencyTextView.text = "1"
                    }
                }
            }

            observe(viewModel.isLoading) { isLoading ->
                progressCurrency.isVisible = isLoading
            }

            baseCurrencyEditText.doAfterTextChanged {
                if (it.isNullOrEmpty()) {
                    baseCurrencyTextView.text = "1"
                    currenciesCount = 1.0
                } else {
                    baseCurrencyCount = it.toString().toDouble()
                }
                currenciesTextView.text =
                    viewModel.setSecondCurrencyTV(baseCurrencyCount, currenciesRate)
                baseCurrencyTextView.text = baseCurrencyEditText.text
                if (currenciesEditText.text.toString() != "") {
                    currenciesEditText.setText("", TextView.BufferType.EDITABLE)
                }
            }

            currenciesEditText.doAfterTextChanged {
                if (it.isNullOrEmpty()) {
                    currenciesTextView.text = "1"
                    baseCurrencyTextView.text = ""
                    currenciesTextView.text = ""
                } else {
                    currenciesCount = it.toString().toDouble()
                    baseCurrencyTextView.text =
                        viewModel.setFirstCurrencyTV(currenciesCount, currenciesRate)
                    currenciesTextView.text = currenciesEditText.text
                }
                baseCurrencyTextView.text =
                    viewModel.setFirstCurrencyTV(currenciesCount, currenciesRate)
                currenciesTextView.text = currenciesEditText.text
                if (baseCurrencyEditText.text.toString() != "1") {
                    baseCurrencyEditText.setText("1", TextView.BufferType.EDITABLE)
                }
            }

            val baseCurrencyAdapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.currencies,
                R.layout.item_currency_convert
            )
            val currenciesAdapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.currencies,
                R.layout.item_currency_convert
            )
            baseCurrencyAdapter.setDropDownViewResource(R.layout.item_drop_down_list)
            currenciesAdapter.setDropDownViewResource(R.layout.item_drop_down_list)

            spinnerBaseCurrency.adapter = baseCurrencyAdapter
            spinnerCurrencies.adapter = currenciesAdapter
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        with(binding) {
            baseCurrency = spinnerBaseCurrency.selectedItem.toString()
            currencies = spinnerCurrencies.selectedItem.toString()

            viewModel.getCurrencyConvertData(
                apikey = APIKEY,
                baseCurrency = baseCurrency,
                currencies = currencies
            )
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}