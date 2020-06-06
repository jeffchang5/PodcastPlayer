package io.jeffchang.core

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers

interface ContextProvider {
    val main: CoroutineContext
    val io: CoroutineContext
    val default: CoroutineContext
}

data class DefaultContextProvider(
    override val main: CoroutineContext = Dispatchers.Main,
    override val io: CoroutineContext = Dispatchers.IO,
    override val default: CoroutineContext = Dispatchers.Default
) : ContextProvider

class TestContextProvider : ContextProvider {
    override val main: CoroutineContext = Dispatchers.Unconfined
    override val io: CoroutineContext = Dispatchers.Unconfined
    override val default: CoroutineContext = Dispatchers.Unconfined
}
