package com.example.sum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ScoreAdapter: ListAdapter<ScoreItem, ScoreAdapter.ViewHolder>(Comparator()) {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val score = view.findViewById<TextView>(R.id.score_text)

        fun bind(scoreItem: ScoreItem){
            if (scoreItem.score != null){
                score.text = scoreItem.score
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.score_item, parent, false))
    }

    override fun onBindViewHolder(holder: ScoreAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class Comparator: DiffUtil.ItemCallback<ScoreItem>(){
        override fun areItemsTheSame(oldItem: ScoreItem, newItem: ScoreItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ScoreItem, newItem: ScoreItem): Boolean {
            return oldItem == newItem
        }
    }

}