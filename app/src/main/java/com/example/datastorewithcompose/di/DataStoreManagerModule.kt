package com.example.datastorewithcompose.di

import com.example.datastorewithcompose.data.DataStoreManager
import com.example.datastorewithcompose.data.DataStoreManagerImpl
import com.example.datastorewithcompose.servises.TaskServices
import com.example.datastorewithcompose.servises.TaskServicesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreManagerModule {


    @Singleton
    @Binds
    abstract fun bindDataStoreRepository(dataStoreManagerImpl: DataStoreManagerImpl): DataStoreManager

    @Singleton
    @Binds
    abstract fun bindTaskServices(taskServicesImpl: TaskServicesImpl): TaskServices

}