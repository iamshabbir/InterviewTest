package com.example.interviewtest


import android.icu.text.NumberFormat
import android.icu.util.Currency
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewtest.databinding.ListItemBinding

class ListAdapter(private val items: List<Item>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private var filteredList: List<Item> = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = Currency.getInstance("INR")
        val item = filteredList[position]
        holder.textView.text = item.name
        val amount = format.format(item.price)
        holder.textPrice.text = amount
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    inner class ViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView = binding.textView
        val textPrice = binding.textPrice
    }

    /*-----For Search Filter -----*/
    fun filter(query: String) {
        filteredList = if (query.isNotEmpty()) {
            items.filter { data ->
                data.name.contains(query, ignoreCase = true)
            }
        } else {
            items
        }
        notifyDataSetChanged()
    }

    fun updateItem(items: List<Item>) {
        filteredList = items
        notifyDataSetChanged()
    }
}
