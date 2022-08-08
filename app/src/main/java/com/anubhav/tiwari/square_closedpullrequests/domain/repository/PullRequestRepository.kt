package com.anubhav.tiwari.square_closedpullrequests.domain.repository

import com.anubhav.tiwari.square_closedpullrequests.data.remote.dto.PullRequestDTO

interface PullRequestRepository {

    suspend fun getPullRequests(): List<PullRequestDTO>
}