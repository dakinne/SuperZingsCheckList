package com.noox.checklist.core.api

import com.noox.checklist.core.model.SuperZing
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/serie5superzings")
    suspend fun loadSuperZings(): Response<List<SuperZing>>
}