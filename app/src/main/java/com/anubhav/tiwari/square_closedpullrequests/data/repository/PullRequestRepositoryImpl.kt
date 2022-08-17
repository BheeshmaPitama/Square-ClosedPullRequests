package com.anubhav.tiwari.square_closedpullrequests.data.repository

import com.anubhav.tiwari.square_closedpullrequests.common.Constants.REQUEST_STATUS
import com.anubhav.tiwari.square_closedpullrequests.common.Resource
import com.anubhav.tiwari.square_closedpullrequests.data.remote.OkHttpPullsApi
import com.anubhav.tiwari.square_closedpullrequests.data.remote.dto.toPullRequestItem
import com.anubhav.tiwari.square_closedpullrequests.domain.model.PullRequestItem
import com.anubhav.tiwari.square_closedpullrequests.domain.repository.PullRequestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PullRequestRepositoryImpl @Inject constructor(
    private val pullsApi: OkHttpPullsApi
): PullRequestRepository {
    override suspend fun getPullRequests(): Flow<Resource<List<PullRequestItem>>> = flow {
        try {
            emit(Resource.Loading())
            val pullRequests = pullsApi.getPullRequestList(REQUEST_STATUS).map { it.toPullRequestItem() }
            emit(Resource.Success<List<PullRequestItem>>(pullRequests))
        }catch (e: HttpException){
            emit(Resource.Error<List<PullRequestItem>>(e.localizedMessage?: "An Unexpected Error Occurred!"))
        }catch (e: IOException){
            emit(Resource.Error<List<PullRequestItem>>("Couldn't Reach Server! Please check your Internet Connection!"))
        }

    }
}