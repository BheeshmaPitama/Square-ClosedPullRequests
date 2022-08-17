package com.anubhav.tiwari.square_closedpullrequests.presentation.pull_request_list

import com.anubhav.tiwari.square_closedpullrequests.presentation.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PullRequestViewModelTest{
    private val testRobot = PullRequestListViewModelRobot()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun checkIfInitialUiStateIsLoading() {
        val initialState = PullRequestListState()

        testRobot
            .buildViewModel()
            .assertViewState(expectedViewState = initialState)
    }
}