package com.udemy.photogallery.mvp.main

import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.udemy.photogallery.R
import com.udemy.photogallery.mvp.main.fragments.favorites.FavoritesFragment
import com.udemy.photogallery.mvp.main.fragments.gallery.GalleryFragment
import com.udemy.photogallery.mvp.main.fragments.settings.SettingsFragment

class MainPresenter(private var mainView:IMain.View):IMain.Presenter {


    override fun onBottomClick(menuItem: MenuItem) {
        mainView.showProgressBar()
        var fragment:Fragment?=null
        var fragmentIndex=0
        when(menuItem.itemId){

            R.id.navigationFavorites->{

                fragment=FavoritesFragment(this)
                fragmentIndex=0
            }

            R.id.navigationGallery->{

                fragment=GalleryFragment(this)
                fragmentIndex=1
            }
            R.id.navigationSettings->{

                fragment=SettingsFragment(this)
                fragmentIndex=2
            }
        }


        if(fragment!=null){
            mainView.showFragment(fragment,fragmentIndex)

        }



    }

    override fun fragmentWasLoaded() {
        android.os.Handler().postDelayed({

            mainView.hideProgressBar()
            mainView.showFrame()
        },300)
    }

    override fun configureView() {
       var fragment=FavoritesFragment(this)
        mainView.showFragment(fragment,0)

    }


}