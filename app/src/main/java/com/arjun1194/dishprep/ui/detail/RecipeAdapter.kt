package com.arjun1194.dishprep.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arjun1194.dishprep.R
import com.arjun1194.dishprep.data.model.Recipe
import com.arjun1194.dishprep.databinding.RecipeItemBinding


class RecipeAdapter : ListAdapter<Recipe,RecipeAdapter.RecipeVH>(RecipeDiffCallback()) {

    inner class RecipeVH(private val binding: RecipeItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Recipe){
            binding.data = item
        }
    }

     class RecipeDiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        return RecipeVH(RecipeItemBinding.bind(view));
    }

    override fun onBindViewHolder(holder: RecipeVH, position: Int) {
        holder.bind(getItem(position))
    }
}