package com.abousalem.hanginkotlin.domain.repository

import android.content.SharedPreferences
import com.abousalem.hanginkotlin.domain.api.ApiServices
import com.abousalem.hanginkotlin.entities.request.SignInRequest
import com.abousalem.hanginkotlin.entities.request.SignUpRequest
import com.abousalem.hanginkotlin.entities.response.AuthResponse
import com.abousalem.hanginkotlin.utilities.AUTHTOKEN
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(private val service: ApiServices, private val sharedPreferences: SharedPreferences): IAuthenticationRepository {

    private var prefsEditor: SharedPreferences.Editor = sharedPreferences.edit()


    override fun registerUser(signUpRequest: SignUpRequest): Observable<AuthResponse> {
        return service.registerRequest(signUpRequest)
    }

    override fun signInUser(signInRequest: SignInRequest): Observable<AuthResponse> {
        return service.loginRequest(signInRequest)
    }

    override fun saveUserAuthToken(userToken: AuthResponse) {
        prefsEditor.putString(AUTHTOKEN, userToken.authToken)
        prefsEditor.commit()
    }

    override fun getUserAuthToken(): String {
        return  sharedPreferences.getString(AUTHTOKEN,"Default")!!
    }



}