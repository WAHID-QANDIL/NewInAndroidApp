package com.wahid.newinandroidapp.utils

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().url.newBuilder()
            .addQueryParameter("api_key", "KEY")
            .build()
        return chain.proceed(chain.request().newBuilder().url(request).build())
    }
}