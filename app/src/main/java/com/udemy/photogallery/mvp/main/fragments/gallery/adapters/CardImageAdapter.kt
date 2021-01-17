package com.udemy.photogallery.mvp.main.fragments.gallery.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.udemy.photogallery.R
import com.udemy.photogallery.persistence.entities.ImageData
import kotlinx.android.synthetic.main.item_card_image.view.*

class CardImageAdapter(val context: Context, val data:ArrayList<ImageData>) :BaseAdapter()
{
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(index: Int): ImageData {
        return data[index]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(index: Int, container: View?, parent: ViewGroup?): View {

        var view=container
        var holder:DataViewHolder
        if(view==null) {
            view =LayoutInflater.from(parent!!.context).inflate(R.layout.item_card_image,parent,false)
            holder=DataViewHolder(view)
            view?.tag=holder


        }else{
            holder=view?.tag as DataViewHolder

        }
        holder.bindData(context,getItem(index))


        return view!!
    }

    class DataViewHolder(var view:View):RecyclerView.ViewHolder(view){

        internal  fun bindData(context:Context,data:ImageData){
            view.imageNameTextView.text=data.imageName
            Glide.with(context)
                .load(data.imageResId)
                .into(view.imageHolderView)
        }

    }


}