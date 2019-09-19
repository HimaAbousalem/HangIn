package com.abousalem.hanginkotlin.dagger.module.app

import android.app.Application
import com.abousalem.hanginkotlin.dagger.scope.ApplicationScope
import com.abousalem.hanginkotlin.utilities.HTTP_CACHE_DIR
import com.abousalem.hanginkotlin.utilities.HTTP_CACHE_SIZE
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File

@Module(includes = [ApplicationModule::class])
class NetworkModule {

    @ApplicationScope
    @Provides
    fun getOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()
    }

    @ApplicationScope
    @Provides
    fun cache(context: Application): Cache {
        return Cache(File(context.cacheDir, HTTP_CACHE_DIR), HTTP_CACHE_SIZE.toLong())
    }

    @ApplicationScope
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor { message -> Timber.d(message) }
        return logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

}