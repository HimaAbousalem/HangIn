package com.abousalem.hanginkotlin.dagger.component

import com.abousalem.hanginkotlin.HangInApp
import com.abousalem.hanginkotlin.dagger.module.app.ApiServiceModule
import com.abousalem.hanginkotlin.dagger.module.app.ViewModelFactoryModule
import com.abousalem.hanginkotlin.dagger.module.controller.ControllerModule
import com.abousalem.hanginkotlin.dagger.scope.ApplicationScope
import dagger.Component


@ApplicationScope
@Component(modules = [ApiServiceModule::class, ViewModelFactoryModule::class])
interface ApplicationComponent {
    fun controllerComponent(controllerModule: ControllerModule): ControllerComponent
    fun inject(app: HangInApp)
}
