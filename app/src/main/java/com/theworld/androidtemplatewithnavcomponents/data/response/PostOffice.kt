package com.theworld.androidtemplatewithnavcomponents.data.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostOffice(
    @SerializedName("BranchType")
    val branchType: String,
    @SerializedName("Circle")
    val circle: String,
    @SerializedName("Country")
    val country: String,
    @SerializedName("DeliveryStatus")
    val deliveryStatus: String,
    @SerializedName("Description")
    val description: String,
    @SerializedName("District")
    val district: String,
    @SerializedName("Division")
    val division: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("PINCode")
    val pINCode: String,
    @SerializedName("Region")
    val region: String,
    @SerializedName("State")
    val state: String,
    @SerializedName("Taluk")
    val taluk: String
): Parcelable