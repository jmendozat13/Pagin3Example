package com.example.android.codelabs.paging.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.codelabs.paging.databinding.ReposLoadStateFooterViewItemBinding
import com.example.android.codelabs.paging.ui.ReposLoadStateAdapter.ViewHolder


class ReposLoadStateAdapter(
        private val retry: () -> Unit
) : LoadStateAdapter<ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) = holder.bind(loadState)

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder = ViewHolder.from(parent, retry)

    class ViewHolder(private val binding: ReposLoadStateFooterViewItemBinding,
                     retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.retryButton.also {
                it.setOnClickListener { retry.invoke() }
            }
        }

        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                binding.errorMsg.text = loadState.error.localizedMessage
            }
            binding.progressBar.isVisible = loadState is LoadState.Loading
            binding.retryButton.isVisible = loadState !is LoadState.Loading
            binding.errorMsg.isVisible = loadState !is LoadState.Loading
        }

        companion object {
            fun from(parent: ViewGroup, retry: () -> Unit): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ReposLoadStateFooterViewItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, retry)
            }
        }
    }
}
