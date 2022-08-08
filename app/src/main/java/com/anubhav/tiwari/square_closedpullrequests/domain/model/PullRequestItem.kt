package com.anubhav.tiwari.square_closedpullrequests.domain.model

data class PullRequestItem(
val title: String,
val created_at: String,
val closed_at: String,
val userName: String,
val userImage: String
){
    val createdAt get() = created_at.substring(0,10)
    val closedAt get() = closed_at.substring(0,10)
}
