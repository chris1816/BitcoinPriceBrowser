package com.example.data.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

import com.example.domain.model.Response

interface ApiService {

    @GET("/charts/market-price?")
    fun fetchPrice(@Query("timespan") timespan: String,
                   @Query("rollingAverage") rollingAverage: String,
                   @Query("format") format: String): Observable<Response>
}