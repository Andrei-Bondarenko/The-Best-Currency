package com.example.common

import okhttp3.Interceptor
import okhttp3.Response

class ServerErrorInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
       return chain.proceed(request)
    }
}