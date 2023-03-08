package com.sale.hive.content

import com.sale.hive.data.local.entity.VotesEntity
import com.sale.hive.domain.model.VotesModel

class VotesContent {
    companion object Content {
        val fridgeVoteOneEntity = VotesEntity(
            voteID = "VT001",
            productID = "PRD001",
            userID = "USR002",
            upVote = true,
            downVote = false,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val fridgeVoteTwoEntity = VotesEntity(
            voteID = "VT002",
            productID = "PRD001",
            userID = "USR003",
            upVote = true,
            downVote = false,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val microwaveVoteOneEntity = VotesEntity(
            voteID = "VT003",
            productID = "PRD002",
            userID = "USR002",
            upVote = true,
            downVote = false,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val microwaveVoteTwoEntity = VotesEntity(
            voteID = "VT004",
            productID = "PRD002",
            userID = "USR003",
            upVote = true,
            downVote = false,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val microwaveVoteUpVoteEntity = VotesEntity(
            voteID = "VT005",
            productID = "PRD002",
            userID = "USR004",
            upVote = true,
            downVote = false,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val microwaveVoteDownVoteEntity = VotesEntity(
            voteID = "VT005",
            productID = "PRD002",
            userID = "USR004",
            upVote = false,
            downVote = true,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        // Models
        val fridgeVoteOneModel = VotesModel(
            voteID = "VT001",
            productID = "PRD001",
            userID = "USR002",
            upVote = true,
            downVote = false,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val fridgeVoteTwoModel = VotesModel(
            voteID = "VT002",
            productID = "PRD001",
            userID = "USR003",
            upVote = true,
            downVote = false,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val microwaveVoteOneModel = VotesModel(
            voteID = "VT003",
            productID = "PRD002",
            userID = "USR002",
            upVote = true,
            downVote = false,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val microwaveVoteTwoModel = VotesModel(
            voteID = "VT004",
            productID = "PRD002",
            userID = "USR003",
            upVote = true,
            downVote = false,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val microwaveVoteUpVoteModel = VotesModel(
            voteID = "VT005",
            productID = "PRD002",
            userID = "USR004",
            upVote = true,
            downVote = false,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )

        val microwaveVoteDownVoteModel = VotesModel(
            voteID = "VT005",
            productID = "PRD002",
            userID = "USR004",
            upVote = false,
            downVote = true,
            dateUpdated = "07/03/2023",
            dateCreated = "07/03/2023"
        )
    }
}
