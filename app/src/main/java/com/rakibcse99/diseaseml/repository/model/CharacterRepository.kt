package com.rakibcse99.diseaseml.repository.model

import com.rakibcse99.diseaseml.base.ErrorResponse
import com.rakibcse99.diseaseml.base.Resource

interface CharacterRepository {
    suspend fun getCharacter(): Resource<MutableList<CharacterModel>, ErrorResponse>
}