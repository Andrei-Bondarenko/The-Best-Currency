package com.example.convert_currencies.di

import com.example.common.InjectionModule
import com.example.convert_currencies.api.CurrencyApi
import com.example.convert_currencies.ui.CurrencyViewModel
import com.example.convert_currencies.repository.CurrencyRemoteRepository
import com.example.convert_currencies.repository.CurrencyInfoRepository
import com.example.convert_currencies.interactor.CurrencyInteractor
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