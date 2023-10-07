package com.example.ktor_chat_app.di

import com.example.ktor_chat_app.data.ChatSocketService
import com.example.ktor_chat_app.data.ChatSocketServiceImpl
import com.example.ktor_chat_app.data.MessageService
import com.example.ktor_chat_app.data.MessageServiceImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val appModule = module {

    single<HttpClient> {
        HttpClient(CIO) {
            install(Logging)
            install(WebSockets)
            install(ContentNegotiation) {
                json()
            }
        }
    }

    single<MessageService> {
        MessageServiceImpl(get())
    }

    single<ChatSocketService> {
        ChatSocketServiceImpl(get())
    }

}