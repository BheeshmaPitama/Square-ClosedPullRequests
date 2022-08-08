package com.anubhav.tiwari.square_closedpullrequests.di

import com.anubhav.tiwari.square_closedpullrequests.common.Constants.BASE_URL
import com.anubhav.tiwari.square_closedpullrequests.data.remote.OkHttpPullsApi
import com.anubhav.tiwari.square_closedpullrequests.data.repository.PullRequestRepositoryImpl
import com.anubhav.tiwari.square_closedpullrequests.domain.repository.PullRequestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    // Remote API Dependencies

    @Singleton
    @Provides
    fun providePullRequestsApiService(retrofit: Retrofit) : OkHttpPullsApi =
        retrofit.create(OkHttpPullsApi::class.java)

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Repository Dependencies

    @Singleton
    @Provides
    fun providePullRequestRepository(api: OkHttpPullsApi) : PullRequestRepository{
        return PullRequestRepositoryImpl(api)
    }
}