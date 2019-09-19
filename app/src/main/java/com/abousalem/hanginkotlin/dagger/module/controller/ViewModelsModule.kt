package com.abousalem.hanginkotlin.dagger.module.controller

import androidx.lifecycle.ViewModel
import com.abousalem.hanginkotlin.dagger.scope.ViewModelKey
import com.abousalem.hanginkotlin.view.auth.LoginViewModel
import com.abousalem.hanginkotlin.view.main.PlacesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule{
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun loginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PlacesViewModel::class)
    internal abstract fun signUpViewModel(viewModel: PlacesViewModel): ViewModel
}