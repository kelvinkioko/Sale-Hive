package com.sale.hive.domain.repository

import com.sale.hive.domain.model.VotesModel
import com.sale.hive.util.Response

interface VotesRepository {
    suspend fun insertVotes(votesModel: VotesModel)

    suspend fun loadVotes(productID: String): Response<List<VotesModel>>

    suspend fun deleteVotes(votesModel: VotesModel)
}
