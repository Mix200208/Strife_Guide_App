package com.example.strifeguideapp.models.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
 data class Hero (

    val image:Int,

    val name:String,
    val first_skill:String,
    val first_skill_review: String,
    val second_skill:String,
    val second_skill_review:String,
    val third_skill:String,
    val third_skill_review:String,
    val fourth_skill:String,
    val fourth_skill_review:String,


    ):Parcelable