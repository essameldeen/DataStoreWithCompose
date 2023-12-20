package com.example.datastorewithcompose.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManagerImpl @Inject constructor(
    private val tasksPreferenceStore: DataStore<Preferences>
) : DataStoreManager {

    private val FIRST_TASK = stringPreferencesKey("first_task")
    private val SECOND_TASK = stringPreferencesKey("second_task")
    private val THIRD_TASK = stringPreferencesKey("third_task")
    override suspend fun addTask(tasks: Tasks) {
        tasksPreferenceStore.edit { tasksPreferenceStore ->
            tasksPreferenceStore[FIRST_TASK] = tasks.firstTask
            tasksPreferenceStore[SECOND_TASK] = tasks.secondTask
            tasksPreferenceStore[THIRD_TASK] = tasks.thirdTask
        }
    }

    override fun getTasks(): Flow<Tasks> = tasksPreferenceStore.data.map { taskPreference ->
        Tasks(
            firstTask = taskPreference[FIRST_TASK] ?: "",
            secondTask = taskPreference[SECOND_TASK] ?: "",
            thirdTask = taskPreference[THIRD_TASK] ?: ""

        )
    }

}