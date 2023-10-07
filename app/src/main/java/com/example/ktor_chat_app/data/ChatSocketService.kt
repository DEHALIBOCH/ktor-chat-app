package com.example.ktor_chat_app.data

import com.example.ktor_chat_app.domain.model.Message
import com.example.ktor_chat_app.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(username: String) : Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages() : Flow<Message>

    suspend fun closeSession()
}