package com.example.games.views.progetto.adapters

import ResGames
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.games.databinding.ListaItemsGamesTopBinding

class AdapterTopGAmes(private val context: Context) :
    ListAdapter<ResGames, AdapterTopGAmes.ViewHolder>(ItemsDiffCallback) {


    inner class ViewHolder(val binding: ListaItemsGamesTopBinding) :
        RecyclerView.ViewHolder(binding.root)

    private object ItemsDiffCallback : DiffUtil.ItemCallback<ResGames>() {
        override fun areItemsTheSame(oldItem: ResGames, newItem: ResGames): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ResGames, newItem: ResGames): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ListaItemsGamesTopBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entityConfig = getItem(position)

        holder.binding.tTitolo.text = entityConfig.title
        Glide.with(context).load(entityConfig.thumbnail).centerCrop().into(holder.binding.imageView)

    }
}