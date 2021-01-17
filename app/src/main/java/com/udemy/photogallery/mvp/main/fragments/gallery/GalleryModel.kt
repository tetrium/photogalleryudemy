package com.udemy.photogallery.mvp.main.fragments.gallery

import android.os.Handler
import com.udemy.photogallery.R
import com.udemy.photogallery.persistence.entities.ImageData


class GalleryModel(private var galleryPresenter:IGallery.Presenter):IGallery.Model {




    override fun getImagesFromServer() {


        Handler().postDelayed({

            var images= mutableListOf<ImageData>()
            images.add(ImageData(0, R.drawable.image_1,"Katy"))
            images.add(ImageData(1, R.drawable.image_2,"Gio"))
            images.add(ImageData(3, R.drawable.image_1,"Hello"))

            galleryPresenter.onServerResponse(images as ArrayList<ImageData>)
        },3000)

    }


}