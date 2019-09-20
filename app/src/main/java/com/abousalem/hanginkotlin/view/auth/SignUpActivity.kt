package com.abousalem.hanginkotlin.view.auth

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.abousalem.hanginkotlin.R
import com.abousalem.hanginkotlin.entities.request.SignUpRequest
import com.abousalem.hanginkotlin.entities.response.AuthResponse
import com.abousalem.hanginkotlin.entities.state.ErrorState
import com.abousalem.hanginkotlin.entities.state.LoadingState
import com.abousalem.hanginkotlin.entities.state.SuccessState
import com.abousalem.hanginkotlin.extenstion.hideKeyboard
import com.abousalem.hanginkotlin.extenstion.isOnline
import com.abousalem.hanginkotlin.extenstion.toast
import com.abousalem.hanginkotlin.view.base.BaseActivity
import com.abousalem.hanginkotlin.view.base.ViewModelProvidersFactory
import com.abousalem.hanginkotlin.view.main.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_sign_up.*
import timber.log.Timber
import javax.inject.Inject

class SignUpActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvidersFactory
    private lateinit var authViewModel: AuthViewModel
    private val disposable: CompositeDisposable? = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        getActivityComponent().inject(this)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        authViewModel = ViewModelProvider(this, viewModelFactory)[AuthViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        registerCreateAccountBT.setOnClickListener {
            validateAndSignUp()
        }
    }

    private fun validateAndSignUp() {
        hideKeyboard()

        val firstName = registerFirstNameET.text?.toString()?.trim()
        val lastName = registerLastNameET.text?.toString()?.trim()
        val email = registerEmailET.text?.toString()?.trim()
        val phone = registerPhoneNumberET.text?.toString()?.trim()
        val password = registerPasswordET.text?.toString()?.trim()
        val confirmPassword = registerConfirmPassET.text?.toString()?.trim()

        if(email!!.isEmpty()||password!!.isEmpty()||firstName!!.isEmpty()
            ||lastName!!.isEmpty()||confirmPassword!!.isEmpty()||phone!!.isEmpty()){
            toast("Please Fill all Fields!")
            return
        }

        if(password != confirmPassword){
            toast("Password and Confirm Password Not matching")
            return
        }

        if(!isOnline()) {
            toast("No Internet Connection!")
            return
        }

        val user = SignUpRequest(firstName = firstName, lastName = lastName, email = email,
            password = password, phoneNumber = phone)

        disposable?.add(authViewModel.registerUser(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {when(it) {
                is LoadingState ->{
                    if(it.loading) {
                        registerPB.visibility = View.VISIBLE
                        Timber.d("I'm Loading")
                    }else {
                        registerPB.visibility = View.GONE
                        Timber.d("I'm done Loading")
                    }
                }
                is ErrorState ->{
                    toast(it.message)
                    Timber.d("I'm error State ${it.message}")
                }
                is SuccessState ->{
                    Timber.d("I'm Success State ${it.data?.authToken}")
                    saveToSharedPref(it.data)
                    startActivity(Intent(this, MainActivity::class.java))
                }}},{}))
    }

    private fun saveToSharedPref(data: AuthResponse?) {
        authViewModel.saveUserToken(data!!)
    }

    override fun onStop() {
        super.onStop()
        disposable?.clear()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
