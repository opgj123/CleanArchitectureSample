package com.yhg.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yhg.domain.model.MemoItem
import com.yhg.presentation.databinding.ItemMemoListDetailBinding

class MemoListAdapter(private val itemClickListener: (memoItem:MemoItem) -> Unit) : RecyclerView.Adapter<MemoListAdapter.MemoListViewHolder>(){

    private var memoList:List<MemoItem> = ArrayList()

    override fun getItemCount(): Int = memoList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoListViewHolder =
        MemoListViewHolder(ItemMemoListDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false), itemClickListener)

    override fun onBindViewHolder(holder: MemoListViewHolder, position: Int) {
        holder.bind(memoList[position])
    }

    fun setItem(item: List<MemoItem>){
        memoList = item
        notifyDataSetChanged()
    }

    class MemoListViewHolder(private val binding: ItemMemoListDetailBinding, val onClickItemListener: (MemoItem) -> Unit) : RecyclerView.ViewHolder(binding.root){
        private val tvTitle: TextView = binding.tvTitle
        private val tvDay: TextView = binding.tvDay
        private var currentItem: MemoItem? = null

        init{
            binding.root.setOnClickListener {
                currentItem?.let {
                onClickItemListener(it)
                }
            }
        }

        fun bind(item: MemoItem){
            currentItem = item
            tvTitle.text = item.title
            tvDay.text = item.time
        }
    }
}