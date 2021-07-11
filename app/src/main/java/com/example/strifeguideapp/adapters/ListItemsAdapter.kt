package com.example.strifeguideapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.strifeguideapp.R
import com.example.strifeguideapp.models.data.Item
import com.squareup.picasso.Picasso

class ListItemsAdapter : RecyclerView.Adapter<ListItemsAdapter.ItemsViewHolder>() {

    var data: MutableSet<Item> = mutableSetOf()

    fun setItemsData(items: MutableSet<Item>) {

        data.clear()
        data.addAll(items)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {

        return ItemsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_subjects, parent, false)
        )

    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {

        holder.bindView(data.elementAt(position))
    }

    override fun getItemCount(): Int {

        return data.size
    }

    class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val name_item: TextView = itemView.findViewById(R.id.name_item)
        val review_item: TextView = itemView.findViewById(R.id.review_item)
        val price_item: TextView = itemView.findViewById(R.id.price_item)
        val icon_item: ImageView = itemView.findViewById(R.id.image_item)


        fun bindView(item: Item) {

            name_item.text = item.name_item
            review_item.text = item.review_item
            price_item.text = item.price_item
            Picasso.get().load(item.image).into(icon_item)

        }

    }

}