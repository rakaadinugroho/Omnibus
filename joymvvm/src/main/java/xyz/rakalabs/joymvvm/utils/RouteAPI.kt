package xyz.rakalabs.joymvvm.utils

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface RouteAPI {
    /*
    @return Get Data ( Blank without Params)
     */
    @GET
    fun getData(@Url url:String): Observable<Response<ResponseBody>>

    /*
    @return Get Data With Params ( Return with Params )
     */
    @GET
    fun getDataWithParams(@Url url:String, @QueryMap params:Map<String, String>): Observable<Response<ResponseBody>>

    /*
    @return Get Data With Header Authorization
     */
    @GET
    fun getDataWithHeader(@Url url:String, @Header("Authorization") token: String): Observable<Response<ResponseBody>>

    /*
    @return Get Data With Params & Header Authorization
     */
    @GET
    fun getDataWithParamsWithHeader(@Url url:String, @QueryMap params:Map<String, String>, @Header("Authorization") token: String): Observable<Response<ResponseBody>>

}