package com.abousalem.hanginkotlin.dagger.module.controller

import androidx.lifecycle.ViewModel
import com.abousalem.hanginkotlin.dagger.scope.ViewModelKey
import com.abousalem.hanginkotlin.view.auth.AuthViewModel
import com.abousalem.hanginkotlin.view.main.PlacesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule{
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    internal abstract fun authViewModel(viewModel: AuthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PlacesViewModel::class)
    internal abstract fun placesViewModel(viewModel: PlacesViewModel): ViewModel

}