package com.sale.hive.data.mapper

import com.google.common.truth.Truth.assertThat
import com.sale.hive.content.VotesContent.Content.fridgeVoteOneDTO
import com.sale.hive.content.VotesContent.Content.fridgeVoteOneEntity
import com.sale.hive.content.VotesContent.Content.fridgeVoteOneModel
import com.sale.hive.content.VotesContent.Content.fridgeVoteTwoEntity
import com.sale.hive.content.VotesContent.Content.fridgeVoteTwoModel
import com.sale.hive.content.VotesContent.Content.microwaveVoteDownVoteEntity
import com.sale.hive.content.VotesContent.Content.microwaveVoteDownVoteModel
import com.sale.hive.content.VotesContent.Content.microwaveVoteOneEntity
import com.sale.hive.content.VotesContent.Content.microwaveVoteOneModel
import com.sale.hive.content.VotesContent.Content.microwaveVoteTwoEntity
import com.sale.hive.content.VotesContent.Content.microwaveVoteTwoModel
import com.sale.hive.content.VotesContent.Content.microwaveVoteUpVoteEntity
import com.sale.hive.content.VotesContent.Content.microwaveVoteUpVoteModel
import com.sale.hive.data.mapper.Votes.Mapper.mapDTOToVotesEntity
import com.sale.hive.data.mapper.Votes.Mapper.mapToVotesEntity
import com.sale.hive.data.mapper.Votes.Mapper.mapToVotesModel
import org.junit.Test

class VotesTests {

    @Test
    fun `test mapping votesDTO to votesEntity`() {
        val mappedEntity = fridgeVoteOneDTO.mapDTOToVotesEntity()

        assertThat(mappedEntity).isEqualTo(fridgeVoteOneEntity)
    }

    @Test
    fun `test mapping votesEntity to votesModel`() {
        val voteEntitiesList = mutableListOf(
            fridgeVoteOneEntity,
            fridgeVoteTwoEntity,
            microwaveVoteOneEntity,
            microwaveVoteTwoEntity,
            microwaveVoteUpVoteEntity,
            microwaveVoteDownVoteEntity
        )

        val voteModelsList = mutableListOf(
            fridgeVoteOneModel,
            fridgeVoteTwoModel,
            microwaveVoteOneModel,
            microwaveVoteTwoModel,
            microwaveVoteUpVoteModel,
            microwaveVoteDownVoteModel
        )

        val mappedModels = voteEntitiesList.mapToVotesModel()

        assertThat(mappedModels).isEqualTo(voteModelsList)
    }

    @Test
    fun `test mapping votesModel to votesEntity`() {
        val mappedEntity = microwaveVoteUpVoteModel.mapToVotesEntity()

        assertThat(mappedEntity).isEqualTo(microwaveVoteUpVoteEntity)
    }
}