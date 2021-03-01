package com.example.composejetpackmvvmproject.utiles

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.AmbientContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.composejetpackmvvmproject.R
import kotlinx.coroutines.flow.emptyFlow

val DEFAULTIMAGE = R.drawable.empty


// we had made load image Composable as load image in compose is synchronously so we will make it asynchronously
// by using glide to add image before get network image and if we will get image from resource
// we will also use glide to help me to do that
@Composable
fun LoadImage(url:String,@DrawableRes defaultImage:Int): MutableState<Bitmap?> {
    var bitmap:MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(AmbientContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object :CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmap.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })

    Glide.with(AmbientContext.current)
        .asBitmap()
        .load(url)
        .into(object :CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmap.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }
        })

    return bitmap

}



@Composable
fun LoadImage(@DrawableRes srcId:Int): MutableState<Bitmap?> {
    var bitmap:MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(AmbientContext.current)
        .asBitmap()
        .load(srcId)
        .into(object :CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmap.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })

    return bitmap

}