package com.example.strifeguideapp.fragments

import android.content.Intent
import android.os.Bundle
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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

lateinit var mdata: ArrayList<Hero>
lateinit var heroesAdapter: ListHeroesAdapter
lateinit var recyclerView: RecyclerView




class list_heroes : Fragment() {

    companion object {
         val INTENT_PARCELABLE = "OBJECT_INTENT"
    }



    private fun initdataheroes(){
        mdata = ArrayList<Hero>()
        mdata.add(Hero(R.drawable.ace,"Ace","-","-","-","-","-","-","-","-"))
        mdata.add(Hero(R.drawable.bastion,"Bastion","-","-","-","-","-","-","-","-",))
    }

    fun initView(view: View){
        recyclerView = view.findViewById(R.id.list_h)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
    }

    fun heroesAdapt() {
        heroesAdapter = ListHeroesAdapter(mdata){

            var intent = Intent(this.context,HeroDetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)



        }
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
        var view =  inflater.inflate(R.layout.fragment_list_heroes, container, false)

        initView(view)
        initdataheroes()
        heroesAdapt()
        return view
    }






//    companion object {
//
//
//
//
//
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            list_heroes().apply {
//                arguments = Bundle().apply {
//
//                }
//            }
//    }
}