package com.udemy.photogallery.persistence.webapi

import retrofit2.Call
import com.udemy.photogallery.persistence.entities.ImageData
import retrofit2.http.Body
import retrofit2.http.POST

interface ImagesService {


    @POST("mvp_kotlin")
    fun getImages(): Call<ImagesServiceResponse>

}