package com.abousalem.hanginkotlin.entities.response

data class User(
    val image: String,
    var blocked: Boolean,
    var isActive: Boolean,
    val id: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val createdAt: String,
    val updatedAt: String
)