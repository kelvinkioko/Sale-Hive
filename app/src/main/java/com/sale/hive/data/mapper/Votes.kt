package com.sale.hive.data.mapper

import com.sale.hive.data.local.entity.VotesEntity
import com.sale.hive.data.remote.dto.VotesDTO
import com.sale.hive.domain.model.VotesModel

class Votes {
    companion object Mapper {
        fun VotesDTO.mapDTOToVotesEntity(): VotesEntity {
            return VotesEntity(
                voteID = voteID,
                productID = productID,
                userID = userID,
                upVote = upVote,
                downVote = downVote,
                dateUpdated = dateUpdated,
                dateCreated = dateCreated
            )
        }

        fun VotesModel.mapToVotesEntity(): VotesEntity {
            return VotesEntity(
                voteID = voteID,
                productID = productID,
                userID = userID,
                upVote = upVote,
                downVote = downVote,
                dateUpdated = dateUpdated,
                dateCreated = dateCreated
            )
        }

        fun List<VotesEntity>.mapToVotesModel(): List<VotesModel> {
            val votesModel = mutableListOf<VotesModel>()
            this.map { votesEntity ->
                votesModel.add(
                    VotesModel(
                        voteID = votesEntity.voteID,
                        productID = votesEntity.productID,
                        userID = votesEntity.userID,
                        upVote = votesEntity.upVote,
                        downVote = votesEntity.downVote,
                        dateUpdated = votesEntity.dateUpdated,
                        dateCreated = votesEntity.dateCreated
                    )
                )
            }

            return votesModel
        }
    }
}
