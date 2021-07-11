package com.example.strifeguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.strifeguideapp.fragments.ListHeroesFragment
import com.example.strifeguideapp.fragments.ListHeroesFragment.Companion.INTENT_PARCELABLE
import com.example.strifeguideapp.models.data.Hero
import com.squareup.picasso.Picasso

class HeroDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)
        val hero = intent.getParcelableExtra<Hero>(ListHeroesFragment.INTENT_PARCELABLE)

        var icon= findViewById<ImageView>(R.id.icon_hero)
        var name = findViewById<TextView>(R.id.name_Hero)
        val first_skill = findViewById<TextView>(R.id.name_first_skill)
        val first_skill_review = findViewById<TextView>(R.id.review_first_skill)
        val second_skill = findViewById<TextView>(R.id.name_second_skill)
        val second_skill_review = findViewById<TextView>(R.id.review_second_skill)
        val third_skill = findViewById<TextView>(R.id.name_third_skill)
        val third_skill_review = findViewById<TextView>(R.id.review_third_skill)
        val fourth_skill = findViewById<TextView>(R.id.name_fourth_skill)
        val fourth_skill_review = findViewById<TextView>(R.id.review_fourth_skill)


        if (hero != null) {
            Picasso.get().load(hero.image).into(icon)
            name.text = hero.name
            first_skill.text = hero.first_skill
            first_skill_review.text = hero.first_skill_review
            second_skill.text = hero.second_skill
            second_skill_review.text = hero.second_skill_review
            third_skill.text = hero.third_skill
            third_skill_review.text = hero.third_skill_review
            fourth_skill.text = hero.first_skill
            fourth_skill_review.text = hero.fourth_skill_review

        }








    }
}