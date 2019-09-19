package com.abousalem.hanginkotlin.view.base

import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import com.abousalem.hanginkotlin.HangInApp
import com.abousalem.hanginkotlin.dagger.component.ControllerComponent
import com.abousalem.hanginkotlin.dagger.module.controller.ControllerModule

abstract class BaseActivity: AppCompatActivity(){
    @UiThread
    fun getActivityComponent(): ControllerComponent {
        return (application as HangInApp).component
            .controllerComponent(ControllerModule(this))
    }
}