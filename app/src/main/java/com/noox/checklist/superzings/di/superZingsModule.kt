package com.noox.checklist.superzings.di

import com.noox.checklist.superzings.data.SuperZingsDataSource
import com.noox.checklist.superzings.data.SuperZingsRepository
import com.noox.checklist.superzings.ui.SuperZingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val superZingsModule = module {

    viewModel { SuperZingsViewModel(repository = get()) }

    single { SuperZingsRepository(dataSource = get()) }
    single { SuperZingsDataSource(service = get()) }
}
