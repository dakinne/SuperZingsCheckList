package com.noox.checklist.superzings.data

import com.noox.checklist.core.api.ApiService
import com.noox.checklist.core.api.safeApiCall
import com.noox.checklist.core.model.SuperZing
import com.noox.checklist.core.Result

class SuperZingsDataSource(private val service: ApiService) {

    suspend fun load(): Result<List<SuperZing>> = safeApiCall {

        val response = service.loadSuperZings()
        val body = response.body()

        if (response.isSuccessful && body != null) {
            Result.Success(body)
        } else {
            Result.Error
        }
    }

}
