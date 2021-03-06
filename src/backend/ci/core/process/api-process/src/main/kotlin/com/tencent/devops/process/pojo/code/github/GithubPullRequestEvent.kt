/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-CI 蓝鲸持续集成平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.devops.process.pojo.code.github

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class GithubPullRequestEvent(
    val action: String,
    val number: Long,
    val pull_request: GithubPullRequest,
    val repository: GithubRepository,
    override val sender: GithubSender
) : GithubEvent(sender) {
    companion object {
        const val classType = "pull_request"
    }
}

data class GithubPullRequest(
    val id: Long,
    val url: String,
    val head: GithubPullRequestBranch,
    val base: GithubPullRequestBranch,
    val labels: List<GithubLabel>,
    val comments_url: String?,
    val created_at: String?,
    val update_at: String?,
    val assignees: List<GithubAssignee>,
    val milestone: GithubMilestone?,
    val title: String?,
    val requested_reviewers: List<GithubReviewer>
)

data class GithubPullRequestBranch(
    val ref: String,
    val sha: String,
    val repo: GithubRepo
)

data class GithubRepo(
    val name: String,
    val full_name: String,
    val clone_url: String
)

data class GithubAssignee(
    val login: String?
)

data class GithubReviewer(
    val login: String?
)

data class GithubMilestone(
    val title: String?,
    val due_on: String?
)

data class GithubLabel(
    val name: String
)
