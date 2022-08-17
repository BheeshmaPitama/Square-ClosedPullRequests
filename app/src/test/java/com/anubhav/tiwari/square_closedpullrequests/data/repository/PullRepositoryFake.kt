package com.anubhav.tiwari.square_closedpullrequests.data.repository

import com.anubhav.tiwari.square_closedpullrequests.common.Resource
import com.anubhav.tiwari.square_closedpullrequests.domain.model.PullRequestItem
import com.anubhav.tiwari.square_closedpullrequests.domain.repository.PullRequestRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PullRepositoryFake {
    val mock: PullRequestRepository = mockk()

    fun mockPullRequestListResult(result: Flow<Resource<List<PullRequestItem>>>){
        coEvery { mock.getPullRequests() } returns result
    }
}