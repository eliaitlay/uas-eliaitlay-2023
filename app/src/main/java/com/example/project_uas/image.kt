package com.example.project_uas

import android.accounts.AuthenticatorDescription
import com.google.firebase.database.Exclude

data class image(
val name:String? = null,
var imageUrl:String? = null,
var description: String? = null,
@get:Exclude

var key:String?=null
)
