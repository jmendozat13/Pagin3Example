package com.example.android.codelabs.paging.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.codelabs.paging.R
import kotlinx.android.synthetic.main.load_state_header_view.view.*

class PagingHeaderAdapter :
        RecyclerView.Adapter<PagingHeaderAdapter.PagingHeaderViewHolder>() {

    private var arrowCount: Long = 0

    fun changeArrowCount(value: Long) {
        this.arrowCount = value
        notifyDataSetChanged()
    }

    class PagingHeaderViewHolder(private val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingHeaderViewHolder {
        return PagingHeaderViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.load_state_header_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PagingHeaderViewHolder, position: Int) {
        holder.itemView.count.text = this.arrowCount.toString()
    }

    override fun getItemCount(): Int = 1
}