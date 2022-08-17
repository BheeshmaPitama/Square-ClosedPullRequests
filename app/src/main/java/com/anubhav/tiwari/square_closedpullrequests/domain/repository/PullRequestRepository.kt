package com.anubhav.tiwari.square_closedpullrequests.domain.repository

import com.anubhav.tiwari.square_closedpullrequests.common.Resource
import com.anubhav.tiwari.square_closedpullrequests.data.remote.dto.PullRequestDTO
import com.anubhav.tiwari.square_closedpullrequests.domain.model.PullRequestItem
import kotlinx.coroutines.flow.Flow

interface PullRequestRepository {

    suspend fun getPullRequests(): Flow<Resource<List<PullRequestItem>>>
}