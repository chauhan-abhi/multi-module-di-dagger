package com.abhi.home.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhi.home.databinding.RepoItemBinding

class HomeRepoAdapter: RecyclerView.Adapter<HomeRepoAdapter.RepoItemViewHolder>() {

    private val data: MutableList<RepoItem> = mutableListOf()

    fun setRepoItems(repoItems: List<RepoItem>) {
        data.clear()
        data.addAll(repoItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder {
        val binding = RepoItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RepoItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
     return data.size
    }


    class RepoItemViewHolder(private val binding: RepoItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repoItem: RepoItem) {
            binding.apply {
                repoName.text = repoItem.name
                repoDescription.text = repoItem.description
                starsCount.text = "${repoItem.starsCount}"
                forkCount.text = "${repoItem.forkCount}"
            }
        }
    }

}