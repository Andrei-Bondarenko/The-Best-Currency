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
import com.example.utils.extensions.getName
import com.example.utils.extensions.getRate
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
    private var currencyInfoData: CurrencyInfoData? = null

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
                if (currencyData != null) {
                    showData(currencyData)
                }
                currencyInfoData = currencyData
            }

            observe(viewModel.isLoading) { isLoading ->
                progressCurrency.isVisible = isLoading
            }

            buttonCalculate.setOnClickListener {
                viewModel.getCurrencyConvertData(
                    apikey = APIKEY,
                    baseCurrency = baseCurrency,
                    currencies = currencies
                )
                showData(currencyInfoData)
            }
            baseCurrencyEditText.doAfterTextChanged {
                if (currenciesEditText.text.toString() != "") {
                    currenciesEditText.setText("", TextView.BufferType.EDITABLE)
                }
                if (it.isNullOrEmpty()) {
                    baseCurrencyTextView.text = "1"
                } else {
                    baseCurrencyCount = it.toString().toDouble()
                }

            }

            currenciesEditText.doAfterTextChanged {
                if (baseCurrencyEditText.text.toString() != "1") {
                    baseCurrencyEditText.setText("1", TextView.BufferType.EDITABLE)
                }
                if (it.isNullOrEmpty()) {
                    currenciesTextView.text = "1"
                } else {
                    currenciesCount = it.toString().toDouble()
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


    @SuppressLint("ResourceType")
    fun showData(data: CurrencyInfoData?) {
        with(binding) {

            Timber.d("CURRENCY_DATA ==== $data")
            currenciesName.text = getName(currencyName = currencies,data = data)
            baseCurrencyName.text = getName(currencyName = baseCurrency,data = data)
            currenciesRate = getRate(currencies, data)
            if (currenciesEditText.text.toString() == "" && baseCurrencyEditText.text.toString() != "1") {
                Timber.d("WORKED FIRST IF")
                currenciesTextView.text =
                    (currenciesRate?.let { baseCurrencyCount.times(it) }).toString()
                baseCurrencyTextView.text = baseCurrencyEditText.text
            } else if (currenciesEditText.text.toString() != "" && baseCurrencyEditText.text.toString() == "1") {
                Timber.d("WORKED SECOND IF")
                baseCurrencyTextView.text =
                    (currenciesRate?.let { currenciesCount.div(it) }).toString()
                currenciesTextView.text = currenciesEditText.text
            } else if (currenciesEditText.text.toString() == "" && baseCurrencyEditText.text.toString() == "1") {
                Timber.d("WORKED THIRD IF")
                currenciesTextView.text =
                    (currenciesRate?.let { baseCurrencyCount.times(it) }).toString()
                baseCurrencyTextView.text = "1"
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        with(binding) {
            baseCurrency = spinnerBaseCurrency.selectedItem.toString()
            currencies = spinnerCurrencies.selectedItem.toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}