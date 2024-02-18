package com.example.taskmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanager.adapters.TasksAdapter
import com.example.taskmanager.databinding.ActivityMainBinding
import com.example.taskmanager.services.TaskRepository

class MainActivity : AppCompatActivity() {

    private val repository: TaskRepository = TaskRepository()

    private lateinit var binding: ActivityMainBinding

    private val tasksAdapter = TasksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdBtnOnClickListener()

        binding.taskRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = tasksAdapter
        }

        val tasksList = repository.getTasks()
        tasksAdapter.updateItems(tasksList)
    }

    private fun setAdBtnOnClickListener() {
        binding.addTaskBtn.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }
}