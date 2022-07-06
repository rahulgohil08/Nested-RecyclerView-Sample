package com.theworld.androidtemplatewithnavcomponents.data.response


import com.google.gson.annotations.SerializedName

data class PostOfficeResponseData(
    @SerializedName("Message")
    val message: String,
    @SerializedName("PostOffice")
    val postOffice: List<PostOffice>,
    @SerializedName("Status")
    val status: String
)