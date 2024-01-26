package com.example.tbc_test8_sidebar.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_test8_sidebar.databinding.RecyclerItemBinding
import com.example.tbc_test8_sidebar.presentation.model.RecyclerItem

class MenuItemsRecyclerAdapter :
    RecyclerView.Adapter<MenuItemsRecyclerAdapter.MenuItemsViewHolder>() {

    private var items: List<RecyclerItem> = listOf()
    var itemOnClick: ((Int) -> Unit)? = null

    inner class MenuItemsViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val item = items[position]
            with(binding){
                tvTitle.text = item.title
                ivIcon.setBackgroundResource(item.icon)
            }
        }

        fun listeners(position: Int){
            binding.root.setOnClickListener {
                itemOnClick!!(items[position].id)
            }
        }

    }

    fun setItems(newItems: List<RecyclerItem>) {
        items = newItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemsViewHolder {
        return MenuItemsViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MenuItemsViewHolder, position: Int) {
        holder.bind(position)
        holder.listeners(position)
    }
}