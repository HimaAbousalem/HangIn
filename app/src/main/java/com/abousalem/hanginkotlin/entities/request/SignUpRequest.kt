package com.abousalem.hanginkotlin.entities.request

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    @SerializedName("phone")
    val phoneNumber: String,
    val password: String
)