package com.anubhav.tiwari.square_closedpullrequests.data.remote.dto

data class Head(
    val label: String,
    val ref: String,
    val repo: RepoX,
    val sha: String,
    val user: UserXX
)