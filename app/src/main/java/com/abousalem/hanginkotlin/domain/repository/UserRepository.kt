package com.abousalem.hanginkotlin.domain.repository

import com.abousalem.hanginkotlin.domain.api.ApiServices
import com.abousalem.hanginkotlin.entities.request.SignInRequest
import com.abousalem.hanginkotlin.entities.request.SignUpRequest
import com.abousalem.hanginkotlin.entities.response.AuthResponse
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(private val service: ApiServices): IAuthenticationRepository {

    override fun registerUser(signUpRequest: SignUpRequest): Observable<AuthResponse> {
        return service.registerRequest(signUpRequest)
    }

    override fun signInUser(signInRequest: SignInRequest): Observable<AuthResponse> {
        return service.loginRequest(signInRequest)
    }

}