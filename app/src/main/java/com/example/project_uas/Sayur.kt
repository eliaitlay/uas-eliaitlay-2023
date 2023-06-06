package com.example.project_uas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sayur(
    val imgsayur:Int,
    val namasayur:String,
    val dessayur:String
)
    :Parcelable
