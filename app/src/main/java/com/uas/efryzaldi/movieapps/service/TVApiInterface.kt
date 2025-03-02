package com.uas.efryzaldi.movieapps.service

import com.uas.efryzaldi.movieapps.model.TelevisionResponse
import retrofit2.Call
import retrofit2.http.GET

interface TVApiInterface {
    @GET("/3/tv/popular?api_key=672bdc2cacf7d1a06275a00cf41f2888")
    fun getTVList(): Call<TelevisionResponse>

}