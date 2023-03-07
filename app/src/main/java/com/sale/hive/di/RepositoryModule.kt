package com.sale.hive.di

import com.sale.hive.data.repository.ProductRepositoryImpl
import com.sale.hive.data.repository.VotesRepositoryImpl
import com.sale.hive.domain.repository.ProductRepository
import com.sale.hive.domain.repository.VotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository

    @Binds
    @Singleton
    fun bindVotesRepository(
        votesRepositoryImpl: VotesRepositoryImpl
    ): VotesRepository
}
