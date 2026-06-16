package com.wahid.utils

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().url.newBuilder()
            .addQueryParameter("api_key", "896d68e60e2c28c87331ca85d124bedb")
            .build()
        return chain.proceed(chain.request().newBuilder().url(request).build())
    }
}