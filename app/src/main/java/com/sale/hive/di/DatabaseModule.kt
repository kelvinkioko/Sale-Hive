package com.sale.hive.di

import android.app.Application
import androidx.room.Room
import com.sale.hive.data.local.dao.ProductDao
import com.sale.hive.data.local.dao.VotesDao
import com.sale.hive.data.local.database.SaleHiveDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesSaleHiveDatabase(application: Application): SaleHiveDatabase {
        return Room.databaseBuilder(
            application,
            SaleHiveDatabase::class.java,
            "SaleHive.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesProductDao(saleHiveDatabase: SaleHiveDatabase): ProductDao =
        saleHiveDatabase.productDao()

    @Provides
    @Singleton
    fun providesVotesDao(saleHiveDatabase: SaleHiveDatabase): VotesDao =
        saleHiveDatabase.votesDao()
}
