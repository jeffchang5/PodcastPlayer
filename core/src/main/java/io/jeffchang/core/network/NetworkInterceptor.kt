package io.jeffchang.core.network

import io.jeffchang.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .addHeader(
                "X-ListenAPI-Key",
                BuildConfig.LISTEN_NOTES_API_KEY
            )
            .build()
        return chain.proceed(newRequest)
    }
}