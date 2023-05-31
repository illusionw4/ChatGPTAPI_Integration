package com.asthana.foodrecipe

import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class Chatgptapiclient(private val apiKey: String) {

    private val client = OkHttpClient()

    fun sendMessage(message: String, callback: Callback) {
        val url ="https://api.openai.com/v1/completions"

        val requestBody = JSONObject()
            .put("prompt", message)
            .put("max_tokens", 50)
            .put("model", "text-davinci-003") // Specify the model parameter here

        val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
        val request = Request.Builder()
            .url(url)
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer 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")
            .post(requestBody.toString().toRequestBody(mediaType))
            .build()

        client.newCall(request).enqueue(callback)
    }
}
