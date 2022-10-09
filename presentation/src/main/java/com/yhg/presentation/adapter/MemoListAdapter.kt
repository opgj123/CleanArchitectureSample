package com.yhg.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yhg.domain.model.MemoItem
import com.yhg.presentation.databinding.ItemMemoListDetailBinding

class MemoListAdapter(private val itemClickListener: (memoItem:MemoItem) -> Unit) : RecyclerView.Adapter<MemoListAdapter.MemoListViewHolder>(){

    private var memoList:List<MemoItem> = ArrayList()

    override fun getItemCount(): Int = memoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoListViewHolder =
        MemoListViewHolder(ItemMemoListDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MemoListViewHolder, position: Int) {
        holder.bind(memoList[position])
    }

    fun setItem(item: List<MemoItem>){
        memoList = item
    }

    inner class MemoListViewHolder(private val binding: ItemMemoListDetailBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: MemoItem){
            binding.tvTitle.text = item.title
            binding.tvDay.text = item.time
        }
    }
}