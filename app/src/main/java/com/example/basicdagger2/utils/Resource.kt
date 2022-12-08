package com.example.basicdagger2.utils

data class Resource<out T>(val status: Status, val message: String?, val data: T?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, null, data)
        }

        fun <T> error(message: String?, data: T?): Resource<T> {
            return Resource(Status.ERROR, message, data)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, null, data)
        }
    }
}
