package com.udemy.photogallery.persistence.entities

class ImageData {

    var imageId:Int=0
    var imageResId:Int=0
    var imageName=""


    constructor(imageId:Int,imageResId:Int,imageName:String){
        this.imageId=imageId
        this.imageResId=imageResId
        this.imageName=imageName

    }


}