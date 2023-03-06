package com.sale.hive.domain.model

data class VotesModel(
    var voteID: String = "",
    var productID: String = "",
    var userID: String = "",
    var upVote: Boolean = false,
    var downVote: Boolean = false,
    var dateUpdated: String = "",
    var dateCreated: String = ""
)
