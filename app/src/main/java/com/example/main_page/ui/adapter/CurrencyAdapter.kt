package com.example.main_page.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.main_page.model.currency_info.CurrencyInfo
import com.example.thebestcurrency.R

class CurrencyAdapter() : RecyclerView.Adapter<CurrencyViewHolder>() {

    private val data = mutableListOf<CurrencyInfo?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return CurrencyViewHolder(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val listItem = data[position]
        holder.onBind(listItem)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<CurrencyInfo?>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }
}