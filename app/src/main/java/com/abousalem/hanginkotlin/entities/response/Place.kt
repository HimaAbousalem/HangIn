package com.abousalem.hanginkotlin.entities.response

import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("coverImage")
    var coverImage: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("address")
    var address: String? = null,
    @SerializedName("lat")
    var lat: Double? = 0.0,
    @SerializedName("lng")
    var lng: Double? = 0.0,
    @SerializedName("rating")
    var rating: Double? = 0.0,
    @SerializedName("totalRating")
    var totalRating: Long? = 0,
    @SerializedName("hourPrice")
    var hourPrice: Int? = 0,
    @SerializedName("dayPrice")
    var dayPrice: Int? = 0,
    @SerializedName("capacity")
    var capacity: Int? = 0
)