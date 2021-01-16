package com.udemy.photogallery.mvp.main.fragments.images

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udemy.photogallery.R
import com.udemy.photogallery.mvp.main.IMain

class ImagesFragment(var mainPresenter: IMain.Presenter):Fragment() {



    lateinit var  fragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view=inflater.inflate(R.layout.fragment_images,container,false)
        fragmentView=view
        mainPresenter.fragmentWasLoaded()
        return view
    }

}