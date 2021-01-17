package com.udemy.photogallery.mvp.main.fragments.gallery

import com.udemy.photogallery.persistence.entities.ImageData

class GalleryPresenter(private var galleryView:IGallery.View):IGallery.Presenter {


    private var galleryModel:IGallery.Model=GalleryModel(this)


    override fun configureView() {

    }

    override fun onServerResponse(images: ArrayList<ImageData>) {

    }


}