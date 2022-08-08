package com.anubhav.tiwari.square_closedpullrequests.data.repository

import com.anubhav.tiwari.square_closedpullrequests.common.Constants.REQUEST_STATUS
import com.anubhav.tiwari.square_closedpullrequests.data.remote.OkHttpPullsApi
import com.anubhav.tiwari.square_closedpullrequests.data.remote.dto.PullRequestDTO
import com.anubhav.tiwari.square_closedpullrequests.domain.repository.PullRequestRepository
import javax.inject.Inject

class PullRequestRepositoryImpl @Inject constructor(
    private val pullsApi: OkHttpPullsApi
): PullRequestRepository {
    override suspend fun getPullRequests(): List<PullRequestDTO> {
        return pullsApi.getPullRequestList(REQUEST_STATUS)
    }
}