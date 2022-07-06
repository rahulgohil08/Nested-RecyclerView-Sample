package com.theworld.androidtemplatewithnavcomponents.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.theworld.androidtemplatewithnavcomponents.data.local_json.ParentChildCategory
import com.theworld.androidtemplatewithnavcomponents.databinding.LayoutDataBinding
import com.theworld.androidtemplatewithnavcomponents.ui.dashboard.DashboardFragment

class CategoryAdapter :
    ListAdapter<ParentChildCategory, CategoryAdapter.CustomerViewHolder>(DiffCallback()) {

    private val childAdapter by lazy { ChildCategoryAdapter() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val binding =
            LayoutDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.bind(currentItem)
    }


    inner class CustomerViewHolder(private val binding: LayoutDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ParentChildCategory) {

            binding.apply {
                tvName.text = item.category.parentID

                val detail =
                    item.category.name.first { it.language == DashboardFragment.defaultLanguage }
                tvDescription.text = detail.value


                recyclerView.adapter = childAdapter
                recyclerView.isNestedScrollingEnabled = true

                childAdapter.submitList(item.children)
            }

        }


    }

    class DiffCallback : DiffUtil.ItemCallback<ParentChildCategory>() {
        override fun areItemsTheSame(old: ParentChildCategory, aNew: ParentChildCategory) =
            old.category.categoryId == aNew.category.categoryId

        override fun areContentsTheSame(old: ParentChildCategory, aNew: ParentChildCategory) =
            old == aNew
    }


}