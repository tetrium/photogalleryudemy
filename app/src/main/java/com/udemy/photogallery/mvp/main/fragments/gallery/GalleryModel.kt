package com.udemy.photogallery.mvp.main.fragments.gallery

import android.os.Handler
import com.udemy.photogallery.R
import com.udemy.photogallery.persistence.entities.ImageData
import com.udemy.photogallery.persistence.webapi.ImagesService
import com.udemy.photogallery.persistence.webapi.ImagesServiceResponse
import com.udemy.photogallery.persistence.webapi.ServiceBuilder
import retrofit2.Call
import retrofit2.Response


class GalleryModel(private var galleryPresenter:IGallery.Presenter):IGallery.Model {




    override fun getImagesFromServer() {

        val webApi=ServiceBuilder.buildService(ImagesService::class.java )
        val requestCall=webApi.getImages()

        requestCall.enqueue(object:retrofit2.Callback<ImagesServiceResponse>{
            override fun onResponse(
                call: Call<ImagesServiceResponse>,
                httpResponse: Response<ImagesServiceResponse>
            ) {

                var responseImages=httpResponse.body()
                if(responseImages!=null) {
                    galleryPresenter.onServerResponse(responseImages.images as ArrayList<ImageData>)
                }
            }

            override fun onFailure(call: Call<ImagesServiceResponse>, t: Throwable) {

            }


         }


        )







       /* Handler().postDelayed({

            var images= mutableListOf<ImageData>()
            images.add(ImageData(0, R.drawable.image_1,"Katy"))
            images.add(ImageData(1, R.drawable.image_2,"Gio"))
            images.add(ImageData(3, R.drawable.image_1,"Hello"))

            galleryPresenter.onServerResponse(images as ArrayList<ImageData>)
        },3000)*/





    }


}