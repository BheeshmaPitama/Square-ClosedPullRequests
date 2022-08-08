package com.anubhav.tiwari.square_closedpullrequests.data.remote.dto

import com.anubhav.tiwari.square_closedpullrequests.domain.model.PullRequestItem

data class PullRequestDTO(
    val _links: Links,
    val active_lock_reason: Any,
    val assignee: Any,
    val assignees: List<Any>,
    val author_association: String,
    val auto_merge: Any,
    val base: Base,
    val body: String,
    val closed_at: String,
    val comments_url: String,
    val commits_url: String,
    val created_at: String,
    val diff_url: String,
    val draft: Boolean,
    val head: Head,
    val html_url: String,
    val id: Int,
    val issue_url: String,
    val labels: List<Label>,
    val locked: Boolean,
    val merge_commit_sha: String,
    val merged_at: String,
    val milestone: Any,
    val node_id: String,
    val number: Int,
    val patch_url: String,
    val requested_reviewers: List<RequestedReviewer>,
    val requested_teams: List<Any>,
    val review_comment_url: String,
    val review_comments_url: String,
    val state: String,
    val statuses_url: String,
    val title: String,
    val updated_at: String,
    val url: String,
    val user: UserXX
)

fun PullRequestDTO.toPullRequestItem():PullRequestItem{
    return PullRequestItem(
        title = title,
        created_at = created_at,
        closed_at = closed_at,
        userName = user.login,
        userImage = user.avatar_url
    )
}