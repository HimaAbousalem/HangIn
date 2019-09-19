package com.abousalem.hanginkotlin.domain.api

import com.abousalem.hanginkotlin.entities.request.SignInRequest
import com.abousalem.hanginkotlin.entities.request.SignUpRequest
import com.abousalem.hanginkotlin.entities.response.AuthResponse
import com.abousalem.hanginkotlin.entities.response.User
import com.abousalem.hanginkotlin.entities.response.Place
import io.reactivex.Observable
import retrofit2.http.*

interface ApiServices{
    @Headers("Content-Type: application/json")
    @POST("users/login")
    fun loginRequest(@Body signInRequest: SignInRequest): Observable<AuthResponse>

    @Headers("Content-Type: application/json")
    @POST("users/register")
    fun registerRequest(@Body signUpRequest: SignUpRequest): Observable<AuthResponse>

    @GET("users/me")
    fun getAccount(@Header("x-auth-token") userToken: String): Observable<User>

    @GET("places")
    fun getPlaces (): Observable<List<Place>>

}