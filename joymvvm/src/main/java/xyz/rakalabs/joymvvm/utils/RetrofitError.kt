package xyz.rakalabs.joymvvm.utils

import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class RetrofitError {
    companion object {
        fun resultError(t: Throwable): String {
            return if (t is SocketTimeoutException) {
                "Connection Timeout"
            } else if (t is UnknownHostException) {
                "Connection Timeout"
            } else {
                "Network Connection"
            }
        }
    }
}