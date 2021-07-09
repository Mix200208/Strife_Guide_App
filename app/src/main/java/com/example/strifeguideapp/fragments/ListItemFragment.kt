package com.example.strifeguideapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strifeguideapp.R
import com.example.strifeguideapp.adapters.ListHeroesAdapter
import com.example.strifeguideapp.adapters.ListItemsAdapter
import com.example.strifeguideapp.models.data.Hero
import com.example.strifeguideapp.models.data.Item
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

lateinit var itemsAdapter: ListItemsAdapter
private lateinit var recyclerView: RecyclerView
private val data: MutableSet<Item> = mutableSetOf()
private val database = FirebaseDatabase.getInstance().reference
private val myRef: DatabaseReference = database.child("Items")

class ListItemFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    fun initListItems() {

        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                for (dt in snapshot.children) {

                    val item = dt.getValue<Item>()
                    data.add(item!!)

                }

                itemsAdapter.setItemsData(data)

            }

            override fun onCancelled(error: DatabaseError){
                Log.e("DatabaseError", error.message)
            }

        })

    }

    fun initView(view:View){

        recyclerView = view.findViewById(R.id.list_item)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)

    }

    fun setRecyclerViewAdapter() {

        itemsAdapter = ListItemsAdapter()
        itemsAdapter.setItemsData(data)
        recyclerView.adapter = itemsAdapter


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_items, container, false)
        initView(view)
        initListItems()
        setRecyclerViewAdapter()

        return view
    }


}