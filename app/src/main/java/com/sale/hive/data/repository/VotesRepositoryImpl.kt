package com.sale.hive.data.repository

import com.sale.hive.data.local.dao.VotesDao
import com.sale.hive.data.mapper.Votes.Mapper.mapToVotesEntity
import com.sale.hive.data.mapper.Votes.Mapper.mapToVotesModel
import com.sale.hive.domain.model.VotesModel
import com.sale.hive.domain.repository.VotesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VotesRepositoryImpl @Inject constructor(
    private val votesDao: VotesDao
) : VotesRepository {
    override suspend fun insertVotes(votesModel: VotesModel) {
        val voteEntity = votesModel.mapToVotesEntity()

        votesDao.insertVotes(votesEntity = voteEntity)
    }

    override suspend fun loadVotes(productID: String): List<VotesModel> {
        return votesDao.loadVotes(productID = productID).mapToVotesModel()
    }

    override suspend fun deleteVotes(votesModel: VotesModel) {
        val voteEntity = votesModel.mapToVotesEntity()

        votesDao.deleteVotes(votesEntity = voteEntity)
    }
}
