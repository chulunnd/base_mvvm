package com.example.core.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(resDrawable: Int) {
    Glide.with(this)
        .load(resDrawable)
        .into(this)
}

fun ImageView.loadImage(urlImage: String, placeHolder: Int, isCircle: Boolean = false) {
    if (isCircle) {
        Glide.with(this)
            .load(urlImage)
            .circleCrop()
            .placeholder(placeHolder)
            .into(this)
    } else {
        Glide.with(this)
            .load(urlImage)
            .placeholder(placeHolder)
            .into(this)
    }

}