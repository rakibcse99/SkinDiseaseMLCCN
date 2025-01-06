package com.rakibcse99.diseaseml.repository.model

import com.rakibcse99.diseaseml.data.source.CharacterApi
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val apiService: CharacterApi) :
    CharacterRepository {
//    override suspend fun getCharacter(): Resource<MutableList<CharacterModel>, ErrorResponse> {
//        val response = apiService.getCharactersList()
//        return if (response.isSuccessful) {
//            Resource.success(response.body())
//        } else {
//            Resource.error(
//                null,
//                error = ErrorResponse(
//                    success = false,
//                    message = response.message(),
//                    code = response.code()
//                )
//            )
//        }
//    }

    override suspend fun detectSkinDisease(image: MultipartBody.Part): Response<ResponseBody> {
        return apiService.detectSkinDisease(image)
    }


}