package com.stone.mvpxml.presenter

import com.stone.mvpxml.inerfaces.Pinterface
import com.stone.mvpxml.inerfaces.Posts
import com.stone.mvpxml.launchOnMain
import com.stone.mvpxml.model.MainActivityMOdel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivitypreseeter(val views: Pinterface.MyViews,val mOdel: Pinterface.Model):Pinterface.Presenter,Pinterface.Model.onFinishlistner{
    var scope= CoroutineScope(Dispatchers.IO)
    override fun getposts() {
        scope.launch {
mOdel.fetchposts(this@MainActivitypreseeter)}
    }

    override fun postdata(posts: Posts) {
        CoroutineScope(Dispatchers.IO).launch() {
         mOdel.postdat(this@MainActivitypreseeter,posts)
        }
    }


    override fun onDestroy() {
scope.cancel()    }

    override fun onLoading() {
        scope.launchOnMain {
            views.onLoading()
        }

    }

    override fun onsett(text:String,name:String,id:Int,Idw:Int) {
        scope.launchOnMain{ views.onsettext(text,name,id,Idw)}
    }

    override fun postdatas(posts: Posts) {
        scope.launchOnMain { views.postdata(posts) }
    }


    override fun onSuccess(list: List<Posts>) {
        scope.launchOnMain {views.onSuccess(list)  }

    }

    override fun onError(msg: String) {
    scope.launchOnMain {  views.onError(msg)}
    }




}