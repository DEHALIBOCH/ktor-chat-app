package com.example.ktor_chat_app.data

import com.example.ktor_chat_app.domain.model.Message

interface MessageService {

    suspend fun getAllMessages() : List<Message>

    companion object {
        const val BASE_URL = "http://10.0.2.2:8082"
    }

    sealed class Endpoints(val url : String) {

        data object GetAllMessages : Endpoints("$BASE_URL/messages")
    }
}