package com.example.main_page.di

import com.example.common.InjectionModule
import com.example.main_page.api.CurrencyApi
import com.example.main_page.ui.CurrencyViewModel
import com.example.main_page.repository.CurrencyRemoteRepository
import com.example.main_page.repository.CurrencyInfoRepository
import com.example.main_page.interactor.CurrencyInteractor
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object CurrencyModule: InjectionModule {

    override fun create() = module {
        single { get<Retrofit>().create(CurrencyApi::class.java) }
        single { CurrencyRemoteRepository(get()) } bind CurrencyInfoRepository::class
        factoryOf(::CurrencyInteractor)

        viewModelOf(::CurrencyViewModel)

    }
}