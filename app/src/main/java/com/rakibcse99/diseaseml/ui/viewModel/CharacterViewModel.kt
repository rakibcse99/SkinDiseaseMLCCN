package com.rakibcse99.diseaseml.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakibcse99.diseaseml.base.ErrorResponse
import com.rakibcse99.diseaseml.base.Resource
import com.rakibcse99.diseaseml.repository.model.CharacterModel
import com.rakibcse99.diseaseml.repository.model.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(val repository: CharacterRepository) : ViewModel(){

//    private var _characterModelResult =
//        MutableSharedFlow<Resource<MutableList<CharacterModel>, ErrorResponse>>()
//    var characterModelResult: SharedFlow<Resource<MutableList<CharacterModel>, ErrorResponse>> =
//        _characterModelResult
//
//    fun getCharacter() = viewModelScope.launch {
//        _characterModelResult.emit(Resource.loading(null))
//        _characterModelResult.emit(repository.getCharacter())
//    }
//    fun detectSkinDisease(image: MultipartBody.Part, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
//        viewModelScope.launch {
//            try {
//                val response = repository.detectSkinDisease(image)
//                onSuccess(response.string())
//            } catch (e: Exception) {
//                onError(e.message ?: "An error occurred")
//            }
//        }
//    }


//    fun detectSkinDisease(
//        image: MultipartBody.Part,
//        onSuccess: (String) -> Unit,
//        onError: (String) -> Unit
//    ) {
//        viewModelScope.launch {
//            try {
//                val response: Response<ResponseBody> = repository.detectSkinDisease(image)
//                if (response.isSuccessful) {
//                    // Convert the response body to a string or JSON
//                    val responseBody = response.body()?.string()
//                    onSuccess(responseBody ?: "No response from server")
//                } else {
//                    // Handle API errors
//                    val errorMessage = response.errorBody()?.string() ?: "Unknown error occurred"
//                    onError("Error: $errorMessage")
//                }
//            } catch (e: Exception) {
//                // Handle network or other exceptions
//                onError(e.message ?: "An unexpected error occurred")
//            }
//        }
//    }



    private val _uploadResult = MutableLiveData<String>()
    val uploadResult: LiveData<String> get() = _uploadResult

    fun uploadImage(image: MultipartBody.Part) {
        viewModelScope.launch {
            try {
                val response = repository.detectSkinDisease(image)
                if (response.isSuccessful) {
                    _uploadResult.postValue("Upload Successful: ${response.body()?.string()}")
                } else {
                    _uploadResult.postValue("Upload Failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                _uploadResult.postValue("Error: ${e.message}")
            }
        }
    }
}


