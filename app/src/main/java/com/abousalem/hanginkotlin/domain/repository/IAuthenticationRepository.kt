package com.abousalem.hanginkotlin.domain.repository

import com.abousalem.hanginkotlin.entities.request.SignInRequest
import com.abousalem.hanginkotlin.entities.request.SignUpRequest
import com.abousalem.hanginkotlin.entities.response.AuthResponse
import io.reactivex.Observable

interface IAuthenticationRepository{
    fun registerUser(signUpRequest: SignUpRequest): Observable<AuthResponse>
    fun signInUser(signInRequest: SignInRequest): Observable<AuthResponse>
}