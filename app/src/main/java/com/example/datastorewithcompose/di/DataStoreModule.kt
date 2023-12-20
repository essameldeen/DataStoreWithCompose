package com.example.datastorewithcompose.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {

    private val Context.taskPreferenceStore: DataStore<Preferences> by preferencesDataStore(name = "store_tasks")

    @Singleton
    @Provides
    fun provideTaskPreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.taskPreferenceStore
    }
}