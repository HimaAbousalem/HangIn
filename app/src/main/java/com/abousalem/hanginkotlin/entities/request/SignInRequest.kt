package com.abousalem.hanginkotlin.entities.request


data class SignInRequest(
    val email: String,
    val password: String
)