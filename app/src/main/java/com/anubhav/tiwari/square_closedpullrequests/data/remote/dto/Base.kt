package com.anubhav.tiwari.square_closedpullrequests.data.remote.dto

data class Base(
    val label: String,
    val ref: String,
    val repo: Repo,
    val sha: String,
    val user: UserXX
)