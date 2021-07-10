package com.example.gdsc_app_mobile.services

import com.example.gdsc_app_mobile.models.*
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @GET("v1/faqs")
    fun getAllFaqs(): Call<List<FaqModel>>

    @POST("v1/faqs")
    fun postFaq(@Header("Authorization") authHeader : String, @Body model: FaqPostModel) : Call<FaqModel>

    @DELETE("v1/faqs/{id}")
    fun deleteFaq(@Header("Authorization") authHeader : String,@Path("id") id: String?): Call<FaqModel>

    @POST("v1/auth/login")
    fun postLoginEntry(@Body model: LoginModel) : Call<TokenModel>

    @POST("v1/contact")
    fun postContact(@Body model: ContactPostModel): Call<ContactModel>

    @POST("v1/events")
    fun postEvent(@Header("Authorization") authHeader : String,@Body model: EventModel) : Call<EventModel>

    @GET("v1/events")
    fun getAllEvents(): Call<List<EventModel>>

    /*@Multipart
    @POST("api/v1/files")
    fun upload(
        @Part("description") description: RequestBody?,
        @Part file: Part?
    ): Call<ResponseBody?>?*/


}