package com.example.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main_page.model.currency_info.CurrencyInfo
import com.example.thebestcurrency.databinding.ItemCurrencyBinding
import com.example.utils.extensions.getDrawable

class CurrencyViewHolder(
    private val binding: ItemCurrencyBinding,
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun onBind(item: CurrencyInfo?) {

        val description = item?.name

        with(binding) {
            imageViewIconItem.setImageResource(getDrawable(description))
            textViewName.text = item?.name
            textViewSymbol.text = item?.symbol
            textViewValue.text = item?.rate.toString()

        }
    }
}