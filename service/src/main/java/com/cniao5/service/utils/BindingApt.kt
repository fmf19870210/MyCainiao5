package com.cniao5.service.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *
 * 项目适配用的BindAdapter
 *
 * */

/**
 * imageView支持图片加载 绑定
 */
@BindingAdapter("app:srcCompat",requireAll = false)
fun  imgSrc(iv: ImageView, src:Any?){
    Glide.with(iv).load(src).into(iv)
}


/**
 * 图片资源支持tint颜色修改，支持colorRes和colorInt形式
 */
@BindingAdapter("app:tint")
    fun  imgColor(iv:ImageView,@ColorRes color:Int){
     if(color!=0)iv.setColorFilter(iv.resources.getColor(color))
}


/**
 * textColor的binding形式，支持colorRes和colorInt形式
 */


@BindingAdapter("android:textColor")
fun tvColor(tv: TextView, color:Int){
    if(color==0) return
    tv.setTextColor(tv.resources.getColor(color))
}
