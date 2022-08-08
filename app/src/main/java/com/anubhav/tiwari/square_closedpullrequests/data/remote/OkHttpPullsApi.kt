package com.anubhav.tiwari.square_closedpullrequests.data.remote

import com.anubhav.tiwari.square_closedpullrequests.data.remote.dto.PullRequestDTO
import com.anubhav.tiwari.square_closedpullrequests.data.remote.dto.PullRequestList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OkHttpPullsApi {

    @GET("repos/square/okhttp/pulls")
    suspend fun getPullRequestList(@Query("state") state: String) : PullRequestList

}