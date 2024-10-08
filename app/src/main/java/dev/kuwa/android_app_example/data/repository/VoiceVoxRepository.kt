package dev.kuwa.android_app_example.data.repository

import dev.kuwa.android_app_example.data.api.VoiceVoxApiClient
import dev.kuwa.android_app_example.data.api.voicevox.VoiceVoxService
import dev.kuwa.android_app_example.data.model.VoiceVoxSpeaker

class VoiceVoxRepository() {
    private val apiClient = VoiceVoxApiClient()

    private val service: VoiceVoxService = apiClient.createService(VoiceVoxService::class.java)

//    fun getSample(): Result<List<SampleResponse>> {
//        return try {
//            // RetrofitのAPI呼び出しを非同期で実行
//            val response = service.getSample().execute()
//            if (response.isSuccessful) {
//                // 成功時、結果を返す
//                Result.success(response.body() ?: emptyList())
//            } else {
//                // エラー時、エラーメッセージを含むResultを返す
//                Result.failure(Exception("Error: ${response.code()} - ${response.message()}"))
//            }
//        } catch (e: Exception) {
//            // ネットワークエラーなどの例外を捕捉
//            Result.failure(e)
//        }
//    }

    suspend fun getSpeakers(): Result<List<VoiceVoxSpeaker>> {
        return try {
            // RetrofitのAPI呼び出しを非同期で実行
            val response = service.getSpeakers()
            if (response.isSuccessful) {
                // 成功時、結果を返す
                Result.success(response.body() ?: emptyList())
            } else {
                // エラー時、エラーメッセージを含むResultを返す
                Result.failure(Exception("Error: ${response.code()} - ${response.message()}"))
            }
        } catch (e: Exception) {
            // ネットワークエラーなどの例外を捕捉
            Result.failure(e)
        }
    }

}
