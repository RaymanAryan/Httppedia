package com.rayman.httppedia.data.di

import android.content.Context
import com.rayman.httppedia.data.repository.DataRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideDataRepository(@ApplicationContext context: Context , moshi: Moshi): DataRepository{
        return DataRepository(context,moshi)
    }

}