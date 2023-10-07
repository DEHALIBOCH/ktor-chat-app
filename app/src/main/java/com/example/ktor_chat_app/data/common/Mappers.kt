package com.example.ktor_chat_app.data.common

import com.example.ktor_chat_app.data.remote.dto.MessageDto
import com.example.ktor_chat_app.domain.model.Message
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun MessageDto.toMessage() = Message(
    text = text,
    formattedTime = convertMillisecondsToDateString(timestamp),
    username = username,
)

fun convertMillisecondsToDateString(milliseconds: Long): String {
    val instant = Instant.ofEpochMilli(milliseconds)
    val zoneId = ZoneId.systemDefault()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    return instant.atZone(zoneId).format(formatter)
}