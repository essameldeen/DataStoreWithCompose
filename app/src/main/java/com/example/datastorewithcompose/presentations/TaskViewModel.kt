package com.example.datastorewithcompose.presentations

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datastorewithcompose.data.Tasks
import com.example.datastorewithcompose.servises.TaskServices
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskServices: TaskServices
) : ViewModel() {


    fun saveTask(tasks: Tasks) = viewModelScope.launch {
        Log.d("SAVE", "task save done!")
        taskServices.addTask(tasks)
    }

     fun getTasks() = viewModelScope.launch {
        taskServices.getTaskFromPrefDataStore()
    }

}