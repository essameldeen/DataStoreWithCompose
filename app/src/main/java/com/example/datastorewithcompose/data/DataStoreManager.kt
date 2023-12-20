package com.example.datastorewithcompose.data

import kotlinx.coroutines.flow.Flow

interface DataStoreManager {
    suspend fun addTask(tasks: Tasks)
    fun getTasks(): Flow<Tasks>


}