package com.rakibcse99.diseaseml.data.source

import com.rakibcse99.diseaseml.repository.model.CharacterModel
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface CharacterApi {
//    @GET("api/characters")
//    suspend fun getCharactersList(): Response<MutableList<CharacterModel>>

    @Multipart
    @POST("skin-disease")
    suspend fun detectSkinDisease(
        @Part image: MultipartBody.Part
    ): Response<ResponseBody>


}