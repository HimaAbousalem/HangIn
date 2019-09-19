package com.abousalem.hanginkotlin.entities.response

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("x-auth-token")
    val authToken: String
)