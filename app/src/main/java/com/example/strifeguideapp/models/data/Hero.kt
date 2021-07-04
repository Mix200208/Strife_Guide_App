package com.example.strifeguideapp.models.data

import android.net.Uri
import android.os.Parcelable
import com.google.firebase.database.PropertyName
import kotlinx.android.parcel.Parcelize

@Parcelize
 data class Hero (

   @PropertyName("image") val image:String = "https://firebasestorage.googleapis.com/v0/b/strifeguideapp.appspot.com/o/ace.png?alt=media&token=5283f585-4016-4edf-934b-05fa1d4b5010",
   @PropertyName("name") val name:String = "Имя",
   @PropertyName("first_skill") val first_skill:String = "Название скилла",
   @PropertyName("first_skill_review") val first_skill_review: String = "Обзор скилла",
   @PropertyName("second_skill") val second_skill:String = "Название скилла",
   @PropertyName("second_skill_review") val second_skill_review:String = "Обзор скилла",
   @PropertyName("third_skill") val third_skill:String = "Название скилла",
   @PropertyName("third_skill_review") val third_skill_review:String = "Обзор скилла",
   @PropertyName("fourth_skill") val fourth_skill:String = "Название скилла" ,
   @PropertyName("fourth_skill_review") val fourth_skill_review:String = "Обзор скилла",


   ):Parcelable