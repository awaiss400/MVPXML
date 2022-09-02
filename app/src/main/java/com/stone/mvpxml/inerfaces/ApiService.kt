package com.stone.mvpxml.inerfaces

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
companion object{
    const val BASE_URL="https://jsonplaceholder.typicode.com/"
}
    @GET("posts")
suspend fun getposts():Response<List<Posts>>
@POST("posts")
suspend fun postdata(@Body post: Posts):Response<Posts>
}