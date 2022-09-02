package com.stone.mvpxml.inerfaces

import android.renderscript.ScriptIntrinsicYuvToRGB
import retrofit2.http.POST

interface Pinterface {

interface MyViews{
  fun onLoading()
  fun postdata(posts: Posts)
  fun onSuccess(list: List<Posts>)
  fun onError(msg:String)
  fun onsettext(text:String,name:String,id:Int,Idw:Int)
}
interface Presenter{
fun getposts()
fun postdata(posts: Posts)
fun onDestroy()

}
    interface Model {
    interface onFinishlistner{
        fun onLoading()
fun onsett(text:String,name:String,id:Int,Idw:Int)
        fun postdatas(posts: Posts)
        fun onSuccess(list: List<Posts>)
        fun onError(msg:String)
    }
        suspend fun postdat(onFinishlistner: onFinishlistner,posts: Posts)
suspend fun fetchposts(onFinishlistner: onFinishlistner)
    }
}