package com.abousalem.hanginkotlin.dagger.module.controller

import android.app.Activity
import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.abousalem.hanginkotlin.dagger.scope.ControllerScope
import dagger.Module
import dagger.Provides

@Module
class ControllerModule(private val mActivity: FragmentActivity){

    @ControllerScope
    @Provides
    fun provideContext(): Context {
        return mActivity
    }
    @ControllerScope
    @Provides
    fun provideActivity(): Activity {
        return mActivity
    }
    @ControllerScope
    @Provides
    fun provideFragmentManager(): FragmentManager {
        return mActivity.supportFragmentManager
    }
    @ControllerScope
    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(mActivity)
}