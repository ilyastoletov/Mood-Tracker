package com.dev.data.utils

import com.dev.domain.utils.Response
import retrofit2.HttpException
import java.net.ConnectException

suspend inline fun <T> performNetworkOperation(networkFunction: suspend () -> ApiResponse<T>): Response<T> {
    return try {
        val networkAnswer = networkFunction()
        when(networkAnswer.code) {
            200 -> Response.Success.Data(networkAnswer.data)
            500, 404 -> Response.Error("Информация не найдена или неверный формат запроса. ${networkAnswer.message}")
            else -> Response.Error("Непредвиденная сетевая ошибка, код: ${networkAnswer.code}")
        }
    } catch(e: HttpException) {
        Response.Error("Произошла ошибка на стороне сервера")
    } catch(e: ConnectException) {
        Response.Error("Ошибка соединения с интернетом. Проверьте подключение к сети")
    } finally {
        Response.Success.Empty
    }
}