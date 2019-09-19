package com.abousalem.hanginkotlin.entities.state

import com.abousalem.hanginkotlin.entities.response.AuthResponse

sealed class AuthState
data class LoadingState(var loading: Boolean = false): AuthState()
data class ErrorState(val message: String): AuthState()
data class SuccessState(var data: AuthResponse? = null): AuthState()