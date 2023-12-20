package com.example.datastorewithcompose.servises

import com.example.datastorewithcompose.data.DataStoreManager
import com.example.datastorewithcompose.data.Tasks
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskServicesImpl @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : TaskServices {
    override fun getTaskFromPrefDataStore(): Flow<Tasks> {
        return dataStoreManager.getTasks()
    }

    override suspend fun addTask(tasks: Tasks) {
        dataStoreManager.addTask(tasks)
    }
}