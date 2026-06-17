package com.wahid.newinandroidapp.utils

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.concurrent.TaskRunner.Companion.logger


class HttpLoggingInterceptor : Interceptor{
    @SuppressLint("DefaultLocale")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val requestSystemTime = System.nanoTime()
        logger.info {
            String.format("Sending request %s on %s%n%s",
                request.url, chain.connection(), request.headers
            )
        }

        val response = chain.proceed(request)
        val responseSystemTime = System.nanoTime()

        logger.info {
            String.format("Received response for %s in %.1fms%n%s",
                response.request.url, (requestSystemTime - responseSystemTime) / 1e6, response.headers
            )
        }
        return response
    }

}


