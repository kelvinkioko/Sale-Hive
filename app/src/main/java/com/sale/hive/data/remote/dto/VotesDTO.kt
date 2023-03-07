package com.sale.hive.data.remote.dto

import com.squareup.moshi.Json

data class VotesDTO(
    @field:Json(name = "vote_id") var voteID: String = "",
    @field:Json(name = "product_id") var productID: String = "",
    @field:Json(name = "user_id") var userID: String = "",
    @field:Json(name = "up_vote") var upVote: Boolean = false,
    @field:Json(name = "down_vote") var downVote: Boolean = false,
    @field:Json(name = "date_updated") var dateUpdated: String = "",
    @field:Json(name = "date_created") var dateCreated: String = ""
)
