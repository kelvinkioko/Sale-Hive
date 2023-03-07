package com.sale.hive.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.sale.hive.content.ProductContent
import com.sale.hive.content.VotesContent.Content.fridgeVoteOneEntity
import com.sale.hive.content.VotesContent.Content.fridgeVoteTwoEntity
import com.sale.hive.content.VotesContent.Content.microwaveVoteOneEntity
import com.sale.hive.data.local.database.SaleHiveDatabase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@SmallTest
class VotesDaoTest {

    private lateinit var saleHiveDatabase: SaleHiveDatabase
    private lateinit var votesDao: VotesDao

    @Before
    fun setup() {
        saleHiveDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            SaleHiveDatabase::class.java
        ).allowMainThreadQueries().build()

        votesDao = saleHiveDatabase.votesDao()
    }

    @Test
    fun insertVotes() = runBlocking {
        votesDao.insertVotes(votesEntity = fridgeVoteOneEntity)
        votesDao.insertVotes(votesEntity = fridgeVoteTwoEntity)

        val savedVotes = votesDao.loadVotes(productID = ProductContent.fridgeEntity.productID)

        assertThat(savedVotes).hasSize(2)
    }

    @Test
    fun insertDuplicateVotes() = runBlocking {
        votesDao.insertVotes(votesEntity = fridgeVoteOneEntity)
        votesDao.insertVotes(votesEntity = fridgeVoteOneEntity)

        val savedVotes = votesDao.loadVotes(productID = ProductContent.fridgeEntity.productID)

        assertThat(savedVotes).hasSize(1)
    }

    @Test
    fun loadVotesFromEmptyDatabase() = runBlocking {
        val savedVotes = votesDao.loadVotes(productID = ProductContent.fridgeEntity.productID)

        assertThat(savedVotes).isEmpty()
    }

    @Test
    fun loadVotesFromDatabase() = runBlocking {
        votesDao.insertVotes(votesEntity = fridgeVoteOneEntity)
        votesDao.insertVotes(votesEntity = fridgeVoteTwoEntity)

        val savedVotes = votesDao.loadVotes(productID = ProductContent.fridgeEntity.productID)

        assertThat(savedVotes).contains(fridgeVoteOneEntity)
    }

    @Test
    fun deleteVoteFromDatabase() = runBlocking {
        votesDao.insertVotes(votesEntity = fridgeVoteOneEntity)
        votesDao.insertVotes(votesEntity = microwaveVoteOneEntity)
        votesDao.deleteVotes(votesEntity = fridgeVoteOneEntity)

        val savedVotes = votesDao.loadVotes(productID = ProductContent.fridgeEntity.productID)

        assertThat(savedVotes).doesNotContain(fridgeVoteOneEntity)
    }
}
