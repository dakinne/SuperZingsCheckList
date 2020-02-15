package com.noox.checklist.core.api

import com.noox.checklist.core.Result

/**
 * Wrap a suspending API [call] in try/catch.
 * In case an exception is thrown, a [Result.Error] is created.
 */
suspend fun <T : Any> safeApiCall(call: suspend () -> Result<T>): Result<T> {
    return try {
        call()
    } catch (e: Exception) {
        Result.Error
    }
}
