package com.arjun1194.dishprep.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:srcBinding")
fun setImageSrc(view: ImageView, url:String?){
    url?.let {
        Glide.with(view).load(it).into(view)
    }
}