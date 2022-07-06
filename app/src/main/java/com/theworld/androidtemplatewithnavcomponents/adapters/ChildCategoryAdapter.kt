package com.theworld.androidtemplatewithnavcomponents.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.theworld.androidtemplatewithnavcomponents.data.local_json.Category
import com.theworld.androidtemplatewithnavcomponents.data.response.PostOffice
import com.theworld.androidtemplatewithnavcomponents.databinding.LayoutChildDataBinding

class ChildCategoryAdapter :
    ListAdapter<Category, ChildCategoryAdapter.CustomerViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val binding =
            LayoutChildDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }


    inner class CustomerViewHolder(private val binding: LayoutChildDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {

            /*binding.imgMore.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onClick(getItem(position))
                }
            }

            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {

                    listener.onClick(getItem(position))

                }
            }*/
        }


        fun bind(item: Category) {

            binding.apply {
                tvName.text = item.categoryId
                tvDescription.text = item.name.first().value
            }

        }


    }

    class DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(old: Category, aNew: Category) =
            old.categoryId == aNew.categoryId

        override fun areContentsTheSame(old: Category, aNew: Category) =
            old == aNew
    }


}