package com.abousalem.hanginkotlin.dagger.module.app

import androidx.lifecycle.ViewModelProvider
import com.abousalem.hanginkotlin.view.base.ViewModelProvidersFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule{
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelProvidersFactory): ViewModelProvider.Factory
}