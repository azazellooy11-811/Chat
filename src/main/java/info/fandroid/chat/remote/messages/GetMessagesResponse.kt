package info.fandroid.chat.remote.messages

import info.fandroid.chat.domain.messages.MessageEntity
import info.fandroid.chat.remote.core.BaseResponse

class GetMessagesResponse (
    success: Int,
    message: String,
    val messages: List<MessageEntity>
) : BaseResponse(success, message)