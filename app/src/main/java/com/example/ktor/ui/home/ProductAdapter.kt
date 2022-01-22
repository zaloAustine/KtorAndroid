package com.example.ktor.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ktor.data.models.ResponseModel
import com.example.ktor.databinding.ProductItemBinding

class ProductAdapter() :
    ListAdapter<ResponseModel, ProductAdapter.ViewHolder>(diffUtil) {
    class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResponseModel) {
            with(binding) {

            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

val diffUtil = object : DiffUtil.ItemCallback<ResponseModel>() {
    override fun areItemsTheSame(oldItem: ResponseModel, newItem: ResponseModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResponseModel, newItem: ResponseModel): Boolean {
        return oldItem == newItem
    }
}