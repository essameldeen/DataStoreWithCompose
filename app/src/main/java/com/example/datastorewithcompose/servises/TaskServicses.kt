package com.example.datastorewithcompose.servises

import com.example.datastorewithcompose.data.Tasks
import kotlinx.coroutines.flow.Flow

interface TaskServices {
    fun getTaskFromPrefDataStore(): Flow<Tasks>
    suspend fun addTask(tasks: Tasks)
}