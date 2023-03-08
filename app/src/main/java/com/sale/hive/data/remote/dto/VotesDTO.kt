package com.sale.hive.data.remote.dto

import com.squareup.moshi.Json

data class VotesDTO(
    @field:Json(name = "voteID") var voteID: String = "",
    @field:Json(name = "productID") var productID: String = "",
    @field:Json(name = "userID") var userID: String = "",
    @field:Json(name = "upVote") var upVote: Boolean = false,
    @field:Json(name = "downVote") var downVote: Boolean = false,
    @field:Json(name = "dateUpdated") var dateUpdated: String = "",
    @field:Json(name = "dateCreated") var dateCreated: String = ""
)
