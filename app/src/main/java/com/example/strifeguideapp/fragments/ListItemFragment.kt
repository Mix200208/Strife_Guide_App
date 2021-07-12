package com.example.strifeguideapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strifeguideapp.R
import com.example.strifeguideapp.adapters.ListItemsAdapter
import com.example.strifeguideapp.models.data.Item
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue


class ListItemFragment : Fragment() {

    private lateinit var itemsAdapter: ListItemsAdapter
    private lateinit var recyclerView: RecyclerView
    private val data: MutableSet<Item> = mutableSetOf()
    private val database = FirebaseDatabase.getInstance().reference
    private val myRef: DatabaseReference = database.child("Items")


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

            override fun onCancelled(error: DatabaseError) {
                Log.e("DatabaseError", error.message)
            }

        })

    }

    fun initView(view: View) {

        recyclerView = view.findViewById(R.id.list_item)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }


    }

    fun setRecyclerViewAdapter() {

        itemsAdapter = ListItemsAdapter().apply {
            setItemsData(data)
        }
        recyclerView.adapter = itemsAdapter


    }


    fun clickOnAllItemsButton(view: View){
        val but = view.findViewById<View>(R.id.AllItemsButton)
        but.setOnClickListener {
            itemsAdapter.setItemsData(data)

        }
    }

    fun clickOnWeaponButton(view: View){
        val but = view.findViewById<View>(R.id.WeaponButton)
        but.setOnClickListener {
            itemsAdapter.setItemsData(data.filter { it.specification == "Weapon" }.toMutableSet())

        }
    }

    fun clickOnMagicButton(view: View){
        val but = view.findViewById<View>(R.id.MagicButton)
        but.setOnClickListener {
            itemsAdapter.setItemsData(data.filter { it.specification == "Magic" }.toMutableSet())

        }
    }

    fun clickOnDefButton(view: View){
        val but = view.findViewById<View>(R.id.DefenseButton)
        but.setOnClickListener {
            itemsAdapter.setItemsData(data.filter { it.specification == "Defense" }.toMutableSet())

        }
    }

    fun clickOnBootsButton(view: View){
        val but = view.findViewById<View>(R.id.BootsButton)
        but.setOnClickListener {
            itemsAdapter.setItemsData(data.filter { it.specification == "Boots" }.toMutableSet())

        }
    }





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list_items, container, false)
        clickOnAllItemsButton(view)
        clickOnWeaponButton(view)
        clickOnMagicButton(view)
        clickOnDefButton(view)
        clickOnBootsButton(view)
        initView(view)
        initListItems()
        setRecyclerViewAdapter()

        return view
    }


}