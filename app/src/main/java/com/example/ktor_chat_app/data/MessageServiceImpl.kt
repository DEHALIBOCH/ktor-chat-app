package com.example.ktor_chat_app.data

import com.example.ktor_chat_app.data.common.toMessage
import com.example.ktor_chat_app.data.remote.dto.MessageDto
import com.example.ktor_chat_app.domain.model.Message
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import java.lang.Exception

class MessageServiceImpl(
    private val client: HttpClient
) : MessageService {

    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get(urlString = MessageService.Endpoints.GetAllMessages.url)
                .body<List<MessageDto>>()
                .map { it.toMessage() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}