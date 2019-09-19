package com.abousalem.hanginkotlin.dagger.module.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.abousalem.hanginkotlin.dagger.scope.ApplicationScope
import com.abousalem.hanginkotlin.domain.api.ApiServices
import com.abousalem.hanginkotlin.domain.repository.IAuthenticationRepository
import com.abousalem.hanginkotlin.domain.repository.IPlacesRepository
import com.abousalem.hanginkotlin.domain.repository.PlacesRepositoryImplementer
import com.abousalem.hanginkotlin.domain.repository.UserRepository
import com.abousalem.hanginkotlin.utilities.MyPREFERENCES
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    @ApplicationScope
    @Provides
    fun context(): Application {
        return application
    }
    @ApplicationScope
    @Provides
    fun providesUserRepository(apiServices: ApiServices):IAuthenticationRepository{
        return UserRepository(apiServices)
    }

    @ApplicationScope
    @Provides
    fun providesPlacesRepository(apiServices: ApiServices):IPlacesRepository{
        return PlacesRepositoryImplementer(apiServices)
    }

    @ApplicationScope
    @Provides
    fun provideSharedPrefrence(): SharedPreferences {
        return application.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
    }
}