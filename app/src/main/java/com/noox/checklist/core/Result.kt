package com.noox.checklist.core

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()

    object Error : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error"
        }
    }
}
