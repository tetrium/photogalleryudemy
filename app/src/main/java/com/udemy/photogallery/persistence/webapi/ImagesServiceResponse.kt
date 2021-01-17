package com.udemy.photogallery.persistence.webapi

import com.udemy.photogallery.persistence.entities.ImageData

class ImagesServiceResponse {

    var description:String=""
    var images= mutableListOf<ImageData>()

}