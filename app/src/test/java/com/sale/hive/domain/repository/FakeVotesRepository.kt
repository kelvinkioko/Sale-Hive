package com.sale.hive.domain.repository

import com.sale.hive.content.VotesContent
import com.sale.hive.domain.model.VotesModel
import com.sale.hive.util.Response

class FakeVotesRepository : VotesRepository {
    override suspend fun insertVotes(votesModel: VotesModel) {}

    override suspend fun loadVotes(productID: String): Response<List<VotesModel>> {
        val voteModelsList = mutableListOf(
            VotesContent.fridgeVoteOneModel,
            VotesContent.fridgeVoteTwoModel,
            VotesContent.microwaveVoteOneModel,
            VotesContent.microwaveVoteTwoModel,
            VotesContent.microwaveVoteUpVoteModel,
            VotesContent.microwaveVoteDownVoteModel
        )

        return Response.Success(responseData = voteModelsList)
    }

    override suspend fun deleteVotes(votesModel: VotesModel) {}
}