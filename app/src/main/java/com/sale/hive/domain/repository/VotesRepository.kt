package com.sale.hive.domain.repository

import com.sale.hive.domain.model.VotesModel

interface VotesRepository {
    suspend fun insertVotes(votesModel: VotesModel)

    suspend fun loadVotes(productID: String): List<VotesModel>

    suspend fun deleteVotes(votesModel: VotesModel)
}
