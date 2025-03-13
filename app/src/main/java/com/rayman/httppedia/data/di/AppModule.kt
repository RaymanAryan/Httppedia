package com.rayman.httppedia.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.rayman.httppedia.data.dataStore
import com.rayman.httppedia.data.repository.DataRepository
import com.rayman.httppedia.user_interface.screens.data_screen.Screens
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
    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.dataStore
    }

    @Provides
    @Singleton
    fun provideScreen(): Screens = Screens()

}