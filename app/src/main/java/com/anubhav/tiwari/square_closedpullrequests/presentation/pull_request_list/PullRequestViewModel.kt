package com.anubhav.tiwari.square_closedpullrequests.presentation.pull_request_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anubhav.tiwari.square_closedpullrequests.common.Resource
import com.anubhav.tiwari.square_closedpullrequests.domain.use_case.get_pull_request_list.GetPullRequestListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PullRequestViewModel @Inject constructor(
    private val getPullRequestListUseCase : GetPullRequestListUseCase
):ViewModel() {

    private val _state = mutableStateOf(PullRequestListState())
    val state: State<PullRequestListState> = _state

    init {
        getPullRequests()
    }

    private fun getPullRequests(){
        getPullRequestListUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = PullRequestListState(pullRequests = result.data ?: emptyList())
                }
                is Resource.Error ->{
                    _state.value = PullRequestListState(error = result.message ?: "Unexpected Error Occurred!")
                }
                is Resource.Loading ->{
                    _state.value = PullRequestListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}