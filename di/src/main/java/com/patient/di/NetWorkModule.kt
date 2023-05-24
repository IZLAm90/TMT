package com.patient.di

import com.app.data.remote.UserApi
import com.google.gson.GsonBuilder
import com.patient.data.cashe.PreferencesGateway
import com.patient.data.utils.Constants.PrefKeys.TOKEN
import com.patient.data.utils.Constants.PrefKeys.VARIANT_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        gateway: PreferencesGateway
    ): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.callTimeout(60, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClient.readTimeout(60, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(60, TimeUnit.SECONDS)
        okHttpClient.addNetworkInterceptor { chain ->
            val token = gateway.load(TOKEN, "")
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .method(original.method, original.body)

            requestBuilder.addHeader("Accept", "application/json")
//            requestBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded")
            if (token.isNullOrBlank().not()) {
                requestBuilder.addHeader("Authorization", token!!)
            }

            val request = requestBuilder
                .build()
            return@addNetworkInterceptor chain.proceed(request)
        }
        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(loggingInterceptor)
        }
        okHttpClient.build()
        return okHttpClient.build()
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create(GsonBuilder().serializeNulls().create())
    }

    @Provides
    fun providesBaseUrl(): String {
        return "http://185.137.246.85/"
    }

    @Provides
    fun provideRetrofitClient(
        okHttpClient: OkHttpClient,
        baseUrl: String,
        converterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    fun provideWeatherApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }
}