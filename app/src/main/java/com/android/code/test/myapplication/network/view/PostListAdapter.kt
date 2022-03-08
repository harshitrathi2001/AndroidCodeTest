package com.android.code.test.myapplication.network.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.code.test.BR
import com.android.code.test.R
import com.android.code.test.databinding.PostListItemBinding
import com.android.code.test.myapplication.network.model.Info

class PostListAdapter(private var context: Context) : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {
    private var list: List<Info> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: PostListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.post_list_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    fun setAdapterList(list: List<Info>) {
        this.list = list
        notifyItemRangeInserted(0, list.size);
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(private val binding: PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.model, data)
            binding.executePendingBindings()
        }
    }
}