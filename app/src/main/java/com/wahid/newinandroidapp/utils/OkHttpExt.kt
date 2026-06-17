package com.wahid.newinandroidapp.utils

import okhttp3.OkHttpClient

fun OkHttpClient.Builder.addLoggingInterceptor(): OkHttpClient.Builder = addInterceptor(HttpLoggingInterceptor())
