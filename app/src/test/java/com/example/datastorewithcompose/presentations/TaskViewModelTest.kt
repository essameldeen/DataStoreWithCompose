package com.example.datastorewithcompose.presentations

import com.example.datastorewithcompose.data.Tasks
import com.example.datastorewithcompose.servises.TaskServices
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class TaskViewModelTest {
    private lateinit var viewModel: TaskViewModel
    private val mockTaskServices = mockk<TaskServices>()
    private val dispatcher = TestCoroutineDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        viewModel = TaskViewModel(mockTaskServices)
        Dispatchers.setMain(dispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `verify add task function adds tasks as needed`() = runBlocking {
        val fakeTasks = Tasks(
            firstTask = "finish school work",
            secondTask = "buy gifts for the holiday",
            thirdTask = "finish work"
        )
        val expected = viewModel.saveTask(fakeTasks)

        Assert.assertNotNull(expected)
    }
}