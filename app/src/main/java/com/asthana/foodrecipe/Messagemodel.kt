package com.asthana.foodrecipe

data class MessageModel(
    val message: String,
    val sentBy: String = SENT_BY_ME
) {
    companion object {
        const val SENT_BY_ME: String = "me"
        const val SENT_BY_CHAT: String = "chat"
    }
}

