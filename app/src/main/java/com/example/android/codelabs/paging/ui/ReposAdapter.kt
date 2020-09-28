package com.example.android.codelabs.paging.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.codelabs.paging.R
import com.example.android.codelabs.paging.databinding.RepoViewItemBinding
import com.example.android.codelabs.paging.domain.entities.GithubRepo
import com.example.android.codelabs.paging.ui.ReposAdapter.ViewHolder

/**
 * Adapter for the list of repositories.
 */
class ReposAdapter : PagingDataAdapter<GithubRepo, ViewHolder>(REPO_COMPARATOR) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder.from(parent)

    class ViewHolder private constructor(private val binding: RepoViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GithubRepo?) {
            item?.let { repo ->
                showRepoData(repo)
                itemView.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(repo.url))
                    itemView.context.startActivity(intent)
                }
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RepoViewItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        private fun showRepoData(repo: GithubRepo) {
            binding.github = repo
            // if the description is missing, hide the TextView
            var descriptionVisibility = View.GONE
            if (repo.description != null) {
                binding.repoDescription.text = repo.description
                descriptionVisibility = View.VISIBLE
            }
            binding.repoDescription.visibility = descriptionVisibility

            binding.repoStars.text = repo.stars.toString()
            binding.repoForks.text = repo.forks.toString()

            // if the language is missing, hide the label and the value
            var languageVisibility = View.GONE
            if (!repo.language.isNullOrEmpty()) {
                val resources = this.itemView.context.resources
                binding.repoLanguage.text = resources.getString(R.string.language, repo.language)
                languageVisibility = View.VISIBLE
            }
            binding.repoLanguage.visibility = languageVisibility
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<GithubRepo>() {
            override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean =
                    oldItem.fullName == newItem.fullName

            override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean =
                    oldItem == newItem
        }
    }
}