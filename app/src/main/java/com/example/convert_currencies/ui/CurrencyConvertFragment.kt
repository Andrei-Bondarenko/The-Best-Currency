package com.example.convert_currencies.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import com.example.common.base_ui.BaseFragment
import com.example.convert_currencies.model.currency_info.CurrencyInfoData
import com.example.thebestcurrency.R
import com.example.thebestcurrency.databinding.FragmentCurrencyConvertPageBinding
import com.example.utils.extensions.getRate
import org.koin.android.ext.android.inject


private const val APIKEY = "Ujqc2SLtPZv6C4WcyTMrPHIfbRrjnweCUmAm3JWn"

class CurrencyConvertFragment : BaseFragment(R.layout.fragment_currency_convert_page) {

    private val viewModel: CurrencyViewModel by inject()
    private lateinit var binding: FragmentCurrencyConvertPageBinding
    private var baseCurrency = "USD"
    private var currencies = "USD"

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


            viewModel.getCurrencyConvertData(apikey = APIKEY, baseCurrency = baseCurrency,currencies = currencies)

            observe(viewModel.currencyInfoFlow) { currencyData ->
                if (currencyData != null) {
                    showData(currencyData)

                }
            }

            observe(viewModel.isLoading) { isLoading ->
                progressCurrency.isVisible = isLoading
            }
        }

    }


    @SuppressLint("ResourceType")
    fun showData(data: CurrencyInfoData?) {
        with(binding) {

            val baseCurrencySelected = spinnerBaseCurrency.selectedItem.toString()
            val currenciesSelected = spinnerCurrencies.selectedItem.toString()

            val adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.currencies,
                android.R.layout.simple_spinner_item
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinnerBaseCurrency.adapter = adapter
            spinnerCurrencies.adapter = adapter
            baseCurrency = baseCurrencySelected
            baseCurrencyTextView.text = "1"
            currenciesTextView.text = getRate(currenciesSelected,data).toString()
        }

    }


}