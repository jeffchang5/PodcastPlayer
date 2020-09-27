package io.jeffchang.core

import com.squareup.moshi.JsonDataException
import retrofit2.HttpException
import java.net.UnknownHostException

// Converts details of the API contract to map into domain models that can facilitate cleaner code.
interface DomainMapper<T : Any> {
    fun mapToDomainModel(): T
}

sealed class NetworkException(
    open val errorCode: Int = 0,
    override val message: String = ""
) : Throwable(message)

data class KnownNetworkException(
    override val errorCode: Int,
    val errorBody: String
) : NetworkException(message = "Contains known error")

object UnknownNetworkException : NetworkException(message = "Unknown HTTP exception")

object HostNotFoundNetworkException : NetworkException(message = "Can't connect to the host")

object BadResponseException : NetworkException(message = "Malformed JSON")

// Uses Kotlin sealed classes to create more expressive exception handling in our error block.
private fun catchException(e: Exception): NetworkException {
    return when (e) {
        is HttpException -> KnownNetworkException(e.code(), e.response()?.toString().orEmpty())
        is UnknownHostException -> HostNotFoundNetworkException
        is JsonDataException -> BadResponseException
        else -> UnknownNetworkException
    }
}

// Uses Kotlin sealed classes to encode the possible states of a network call.
sealed class Result<out T : Any>
data class Success<out T : Any>(val data: T) : Result<T>()
data class Failure(val networkException: NetworkException) : Result<Nothing>()

// Wraps around api call and maps it to success or failure states using our DomainMapper.
suspend fun <T : DomainMapper<R>, R : Any> safeApiCall(block: suspend () -> T): Result<R> {
    return try {
        Success(block().mapToDomainModel())
    } catch (e: Exception) {
        Failure(catchException(e))
    }
}
inline fun <T : Any> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Success) action(data)
    return this
}

inline fun <T : Any> Result<T>.onFailure(action: (NetworkException) -> Unit) {
    if (this is Failure) action(networkException)
}
