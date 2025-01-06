package com.rakibcse99.diseaseml.repository.model

import com.rakibcse99.diseaseml.base.ErrorResponse
import com.rakibcse99.diseaseml.base.Resource
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response

interface CharacterRepository {
   // suspend fun getCharacter(): Resource<MutableList<CharacterModel>, ErrorResponse>
    suspend fun detectSkinDisease(image: MultipartBody.Part): Response<ResponseBody>
   // Response<ResponseBody>
}