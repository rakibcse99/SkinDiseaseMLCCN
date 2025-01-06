package com.rakibcse99.diseaseml.di


import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
//    private val appPreferenceImpl: AppPreferenceImpl
) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

      //  val token = appPreferenceImpl.userToken

        request.addHeader("x-rapidapi-key", "452b2113c7msh0f511b3e58275b9p1f5ca3jsn9dd8668802f8")
      //  request.addHeader("x-rapidapi-host", "detect-skin-disease1.p.rapidapi.com")

        return chain.proceed(request.build())
    }
}