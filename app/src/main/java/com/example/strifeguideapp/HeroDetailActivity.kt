package com.example.strifeguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.strifeguideapp.databinding.ActivityHeroDetailBinding
import com.example.strifeguideapp.fragments.ListHeroesFragment
import com.example.strifeguideapp.fragments.ListHeroesFragment.Companion.INTENT_PARCELABLE
import com.example.strifeguideapp.models.data.Hero
import com.squareup.picasso.Picasso

class HeroDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val hero = intent.getParcelableExtra<Hero>(ListHeroesFragment.INTENT_PARCELABLE)
        val binding: ActivityHeroDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_hero_detail)

        if (hero != null) {

            Picasso.get().load(hero.image).into(binding.iconHero)
            binding.nameH = hero.name
            binding.frSkill = hero.first_skill
            binding.frSkillRev = hero.first_skill_review
            binding.scSkill = hero.second_skill
            binding.scSkillRev = hero.second_skill_review
            binding.thSkill = hero.third_skill
            binding.thSkillRev = hero.third_skill_review
            binding.foSkill = hero.fourth_skill
            binding.foSkillRev = hero.fourth_skill_review


        }


    }
}