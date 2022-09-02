package com.stone.mvpxml.model

import android.util.Log
import com.stone.mvpxml.inerfaces.ApiService
import com.stone.mvpxml.inerfaces.Pinterface
import com.stone.mvpxml.inerfaces.Posts

class MainActivityMOdel(val apiService: ApiService):Pinterface.Model{


    override suspend fun postdat(onFinishlistner: Pinterface.Model.onFinishlistner,posts: Posts) {

        onFinishlistner.onLoading()
        try {
            val result=        apiService.postdata(posts)

            if (result.isSuccessful){
                result.body()?.let {
                    onFinishlistner.onSuccess(listOf(it))
                }}else{
                onFinishlistner.onError(result.errorBody().toString())
            }
        }catch (e:Exception){
            onFinishlistner.onError(e.message.toString())
        }
    }

    override suspend fun fetchposts(onFinishlistner: Pinterface.Model.onFinishlistner) {
        onFinishlistner.onLoading()
        try {
            val result=apiService.getposts()
            if (result.isSuccessful){
                result.body()?.let {
                    onFinishlistner.onSuccess(it)
                }}else{
                    onFinishlistner.onError(result.errorBody().toString())
            }
        }catch (e:Exception){
onFinishlistner.onError(e.message.toString())
        }
    }

}