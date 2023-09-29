package com.dev.data.utils

data class ApiResponse<out T>(
    val message: String = "",
    val code: Int,
    val data: T
)