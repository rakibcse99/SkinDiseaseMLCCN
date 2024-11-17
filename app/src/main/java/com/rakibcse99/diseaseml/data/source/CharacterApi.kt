package com.rakibcse99.diseaseml.data.source

import com.rakibcse99.diseaseml.repository.model.CharacterModel
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {
    @GET("api/characters")
    suspend fun getCharactersList(): Response<MutableList<CharacterModel>>




}