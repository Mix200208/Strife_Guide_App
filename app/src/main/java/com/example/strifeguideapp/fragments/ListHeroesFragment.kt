package com.example.strifeguideapp.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strifeguideapp.HeroDetailActivity
import com.example.strifeguideapp.R
import com.example.strifeguideapp.adapters.ListHeroesAdapter
import com.example.strifeguideapp.models.data.Hero
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue


class ListHeroesFragment : Fragment() {

    private lateinit var heroesAdapter: ListHeroesAdapter
    private lateinit var recyclerView: RecyclerView
    private val mdata: MutableSet<Hero> = mutableSetOf()
    private val database = FirebaseDatabase.getInstance().reference
    private val myRef: DatabaseReference = database.child("Heroes")

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private fun initdataheroeslist() {

        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                for (ds: DataSnapshot in snapshot.children) {

                    val hero = ds.getValue<Hero>()
                    mdata.add(hero!!)

                }
                heroesAdapter.setData(mdata)

            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("DatabaseError", error.message)
            }
        })

    }

    fun initView(view: View) {

        recyclerView = view.findViewById(R.id.list_h)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)

    }

    fun setRecyclerViewAdapter() {

        heroesAdapter = ListHeroesAdapter() {

            var intent = Intent(this.context, HeroDetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }

        heroesAdapter.setData(mdata)
        recyclerView.adapter = heroesAdapter

    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        var view = inflater.inflate(R.layout.fragment_list_heroes, container, false)
        initView(view)
        initdataheroeslist()
        setRecyclerViewAdapter()

        return view
    }

}