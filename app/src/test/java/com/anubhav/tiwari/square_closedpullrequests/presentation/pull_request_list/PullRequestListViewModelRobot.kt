package com.anubhav.tiwari.square_closedpullrequests.presentation.pull_request_list

import com.anubhav.tiwari.square_closedpullrequests.common.Resource
import com.anubhav.tiwari.square_closedpullrequests.data.repository.PullRepositoryFake
import com.anubhav.tiwari.square_closedpullrequests.domain.model.PullRequestItem
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.Flow

class PullRequestListViewModelRobot {
    private val repositoryFake = PullRepositoryFake()
    private lateinit var viewModel: PullRequestViewModel

    fun buildViewModel() = apply {
        viewModel = PullRequestViewModel(
            repositoryFake.mock
        )
    }

    fun getPullRequestList() = viewModel.getPullRequests()

    fun mockGetPullRequestList(result: Flow<Resource<List<PullRequestItem>>>) = apply {
        repositoryFake.mockPullRequestListResult(result)
    }

    fun assertViewState(expectedViewState: PullRequestListState) = apply {
        val actualViewState = viewModel.state
        Truth.assertThat(actualViewState).isEqualTo(expectedViewState)
    }


}