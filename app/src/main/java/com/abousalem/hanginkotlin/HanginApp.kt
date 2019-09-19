package com.abousalem.hanginkotlin

import android.app.Application
import com.abousalem.hanginkotlin.dagger.component.ApplicationComponent
import com.abousalem.hanginkotlin.dagger.component.DaggerApplicationComponent
import com.abousalem.hanginkotlin.dagger.module.app.ApplicationModule
import timber.log.Timber

class HangInApp : Application(){
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        component.inject(this)
    }

}
