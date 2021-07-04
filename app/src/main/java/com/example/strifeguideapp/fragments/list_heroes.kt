package com.example.strifeguideapp.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.strifeguideapp.HeroDetailActivity
import com.example.strifeguideapp.R
import com.example.strifeguideapp.adapters.ListHeroesAdapter
import com.example.strifeguideapp.models.data.Hero
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

lateinit var mdata: ArrayList<Hero>
lateinit var heroesAdapter: ListHeroesAdapter
lateinit var recyclerView: RecyclerView

var database = FirebaseDatabase.getInstance().reference
var myRef: DatabaseReference = database.child("Heroes/")



class list_heroes : Fragment() {

    companion object {
         val INTENT_PARCELABLE = "OBJECT_INTENT"
    }




    private fun initdataheroes(){



        myRef.addValueEventListener(object: ValueEventListener {


            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                mdata = ArrayList()
               for(ds:DataSnapshot in snapshot.children){

                   val hero = ds.getValue(Hero::class.java)

                   hero?.let { mdata.add(it) }


               }


            }


            override fun onCancelled(error: DatabaseError) {
                    Log.e("DatabaseError",error.message)
            }}
            )


            mdata.add(Hero())
        // mdata.add(Hero(R.drawable.ace,"Ace","-","-","-","-","-","-","-","-"))
        // mdata.add(Hero(R.drawable.bastion, "Bastion", "-", "-", "-", "-", "-", "-", "-", "-"))
    }

    fun initView(view: View){
        recyclerView = view.findViewById(R.id.list_h)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
    }

    fun heroesAdapt() {
        heroesAdapter = ListHeroesAdapter(mdata){

            val intent = Intent(this.context,HeroDetailActivity::class.java)
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
        mdata = ArrayList()
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