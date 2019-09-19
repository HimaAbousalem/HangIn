package com.abousalem.hanginkotlin.dagger.module.app

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.abousalem.hanginkotlin.dagger.scope.ApplicationScope
import com.abousalem.hanginkotlin.domain.api.ApiServices
import com.abousalem.hanginkotlin.utilities.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [NetworkModule::class])
class ApiServiceModule {

    @ApplicationScope
    @Provides
    fun getGson(): Gson {
        return GsonBuilder()
                //use this if you have an variable that doesn't belong to api req / res
//            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @ApplicationScope
    @Provides
    fun getApiService(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }

    @ApplicationScope
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}