package com.example.strifeguideapp.models.data

import android.net.Uri
import android.os.Parcelable
import com.google.firebase.database.PropertyName
import kotlinx.android.parcel.Parcelize
import com.google.firebase.database.IgnoreExtraProperties

@Parcelize
data class Hero (

   val image:String? = null,
   val name:String? = null,
   val first_skill:String? = null,
   val fiSkillIcon:String? = null,
   val first_skill_review:String? = null,
   val second_skill:String? = null,
   val scSkillIcon:String? = null,
   val second_skill_review:String? = null,
   val third_skill:String? = null,
   val thSkillIcon:String? = null,
   val third_skill_review:String? = null,
   val fourth_skill:String? = null ,
   val frSkillIcon:String? = null,
   val fourth_skill_review:String? = null,

   ):Parcelable