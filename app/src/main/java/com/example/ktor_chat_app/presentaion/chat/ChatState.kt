package com.example.ktor_chat_app.presentaion.chat

import com.example.ktor_chat_app.domain.model.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading : Boolean = false,
)
