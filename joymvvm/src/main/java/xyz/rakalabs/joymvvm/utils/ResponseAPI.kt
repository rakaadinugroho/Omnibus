package xyz.rakalabs.joymvvm.utils

import okhttp3.ResponseBody
import retrofit2.Response

class ResponseAPI(val status: Status, val data: Response<ResponseBody>?, val error: Throwable?) {
    companion object {
        fun loading(): ResponseAPI {
            return ResponseAPI(Status.LOADING, null, null)
        }

        fun success(data: Response<ResponseBody>): ResponseAPI {
            return ResponseAPI(Status.SUCCESS, data, null)
        }

        fun error(error: Throwable): ResponseAPI {
            return ResponseAPI(Status.ERROR, null, error)
        }

        fun finish(): ResponseAPI {
            return ResponseAPI(Status.FINISH, null, null)
        }
    }
}