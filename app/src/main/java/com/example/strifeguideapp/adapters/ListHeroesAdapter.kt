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
import com.squareup.picasso.Picasso

class ListHeroesAdapter(val listdata: List<Hero>,val listener:(Hero)->Unit) : RecyclerView.Adapter<ListHeroesAdapter.HeroesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val convertView = inflater.inflate(R.layout.item_hero,parent,false)
        return HeroesViewHolder(convertView)

    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        //holder.image_hero.setImageResource(listdata.get(position).image)
        //holder.name.text = listdata.get(position).name
        holder.bindView(listdata.get(position),listener)



    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class HeroesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
         var image_hero:ImageView
         var name:TextView

       init{
           image_hero = itemView.findViewById(R.id.logo_hero)
           name = itemView.findViewById(R.id.name_hero)

       }
        fun bindView(hero:Hero,listener: (Hero) -> Unit){
//            image_hero.setImageResource(hero.image)

            Picasso.get().load(hero.image).into(image_hero)
            name.text = hero.name
            itemView.setOnClickListener { listener(hero) }



        }


    }
}