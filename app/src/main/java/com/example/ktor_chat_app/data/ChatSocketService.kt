package com.example.ktor_chat_app.data

import com.example.ktor_chat_app.domain.model.Message
import com.example.ktor_chat_app.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(username: String) : Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages() : Flow<Message>

    suspend fun closeSession()

    companion object {
        const val BASE_URL = "ws://10.0.2.2:8082"
    }

    sealed class Endpoints(val url : String) {

        data object ChatSocket : Endpoints("$BASE_URL/chat-socket")
    }
}