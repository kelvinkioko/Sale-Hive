package com.sale.hive.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "votes", primaryKeys = ["vote_id", "product_id"])
data class VotesEntity(
    @ColumnInfo(name = "vote_id") var voteID: String = "",
    @ColumnInfo(name = "product_id") var productID: String = "",
    @ColumnInfo(name = "user_id") var userID: String = "",
    @ColumnInfo(name = "up_vote") var upVote: Boolean = false,
    @ColumnInfo(name = "down_vote") var downVote: Boolean = false,
    @ColumnInfo(name = "date_updated") var dateUpdated: String = "",
    @ColumnInfo(name = "date_created") var dateCreated: String = ""
)
