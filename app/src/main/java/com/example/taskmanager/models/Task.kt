package com.example.taskmanager.models

import java.util.Date
import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String?,
    val dateTime: Date,
)
