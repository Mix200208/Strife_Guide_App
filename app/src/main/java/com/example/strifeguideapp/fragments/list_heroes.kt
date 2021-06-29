package com.example.strifeguideapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strifeguideapp.R
import com.example.strifeguideapp.adapters.ListHeroesAdapter
import com.example.strifeguideapp.models.data.Hero


class list_heroes : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mdata: ArrayList<Hero>
    lateinit var heroesAdapter: ListHeroesAdapter
    lateinit var recyclerView: RecyclerView


    private fun initdataheroes(){
        mdata = ArrayList<Hero>()
        mdata.add(Hero(R.drawable.ace,"Ace",null,null,null,null))
        mdata.add(Hero(R.drawable.bastion,"Bastion",null,null,null,null))
    }

    fun initView(view: View){
        recyclerView = view.findViewById(R.id.list_heroes)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
    }

    fun heroesAdapt(){
        heroesAdapter = ListHeroesAdapter(mdata)
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
        // Inflate the layout for this fragment

        var view =  inflater.inflate(R.layout.fragment_list_heroes, container, false)

        initView(view)
        initdataheroes()
        heroesAdapt()
        return view

    }



    companion object {

        fun newInstance(param1: String, param2: String) =
            list_heroes().apply {
                arguments = Bundle().apply {

                }
            }
    }
}