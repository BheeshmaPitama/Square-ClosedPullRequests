package com.anubhav.tiwari.square_closedpullrequests.presentation.pull_request_list

import com.anubhav.tiwari.square_closedpullrequests.domain.model.PullRequestItem

data class PullRequestListState (
    val isLoading: Boolean = false,
    val pullRequests: List<PullRequestItem> = emptyList(),
    val error: String? = ""
        )