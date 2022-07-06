package com.theworld.androidtemplatewithnavcomponents.data.local_json


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("_id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("value")
    val value: String
)