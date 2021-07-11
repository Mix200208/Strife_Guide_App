package com.example.strifeguideapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.strifeguideapp.R
import com.example.strifeguideapp.models.data.Hero
import com.squareup.picasso.Picasso

class ListHeroesAdapter(val listener:(Hero)->Unit) : RecyclerView.Adapter<ListHeroesAdapter.HeroesViewHolder>() {

    val listHero:MutableSet<Hero> = mutableSetOf()

    fun setData(newHero:MutableSet<Hero>){
        listHero.clear()
        listHero.addAll(newHero)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val convertView = inflater.inflate(R.layout.item_hero,parent,false)
        return HeroesViewHolder(convertView)

    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {

        holder.bindView(listHero.elementAt(position),listener)

    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    class HeroesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val image_hero:ImageView = itemView.findViewById(R.id.logo_hero)
        val name:TextView = itemView.findViewById(R.id.name_hero)



        fun bindView(hero:Hero,listener: (Hero) -> Unit){

            Picasso.get().load(hero.image).into(image_hero)
            name.text = hero.name
            itemView.setOnClickListener { listener(hero) }

        }


    }
}