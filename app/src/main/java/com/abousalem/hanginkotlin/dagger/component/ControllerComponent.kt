package com.abousalem.hanginkotlin.dagger.component

import com.abousalem.hanginkotlin.dagger.module.controller.ControllerModule
import com.abousalem.hanginkotlin.dagger.module.controller.ViewModelsModule
import com.abousalem.hanginkotlin.dagger.scope.ControllerScope
import com.abousalem.hanginkotlin.view.auth.LoginActivity
import com.abousalem.hanginkotlin.view.auth.SignUpActivity
import com.abousalem.hanginkotlin.view.main.MainActivity
import dagger.Subcomponent

@ControllerScope
@Subcomponent(modules = [ControllerModule::class, ViewModelsModule::class])
interface ControllerComponent{
    fun inject(login: LoginActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(signUpActivity: SignUpActivity)
}