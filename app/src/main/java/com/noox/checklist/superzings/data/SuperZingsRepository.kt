package com.noox.checklist.superzings.data

class SuperZingsRepository(private val dataSource: SuperZingsDataSource) {
    suspend fun load() = dataSource.load()
}