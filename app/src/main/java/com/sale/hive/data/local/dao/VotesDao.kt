package com.sale.hive.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sale.hive.data.local.entity.VotesEntity

@Dao
interface VotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVotes(votesEntity: VotesEntity)

    @Query("SELECT * FROM votes WHERE product_id =:productID")
    suspend fun loadVotes(productID: String): List<VotesEntity>

    @Delete
    suspend fun deleteVotes(votesEntity: VotesEntity)
}
