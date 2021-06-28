package com.example.strifeguideapp.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.strifeguideapp.R
import com.example.strifeguideapp.models.data.Hero

class ListHeroesAdapter:RecyclerView.Adapter<ListHeroesAdapter.HeroesViewHolder>() {

    var heroes:List<Hero> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val convertView = inflater.inflate(R.layout.item_hero,parent,false)
        return HeroesViewHolder(convertView)

    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bind(heroes[position])

    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    class HeroesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var image_hero:ImageView = itemView.findViewById(R.id.logo_hero)
        var name:TextView = itemView.findViewById(R.id.name_hero)
        fun bind(item:Hero){

        }


    }
}