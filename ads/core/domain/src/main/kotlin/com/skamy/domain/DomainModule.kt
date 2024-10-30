package com.skamy.domain

import com.skamy.domain.loadad.LoadAdUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::LoadAdUseCase)
}
