package com.theworld.androidtemplatewithnavcomponents.data.local_json


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("attributeSet")
    val attributeSet: String,
    @SerializedName("categoryId")
    val categoryId: String,
    @SerializedName("categoryNumber")
    val categoryNumber: Int,
    @SerializedName("create_date")
    val createDate: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("featured")
    val featured: Boolean,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("image")
    val image: List<Any>,
    @SerializedName("level")
    val level: Int,
    @SerializedName("name")
    val name: List<Name>,
    @SerializedName("parentID")
    val parentID: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("type")
    val type: Int
)