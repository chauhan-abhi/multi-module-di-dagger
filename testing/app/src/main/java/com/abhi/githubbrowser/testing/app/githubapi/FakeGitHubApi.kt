package com.abhi.githubbrowser.testing.app.githubapi

import com.abhi.githubbrowser.githubapi.model.RepoApiModel
import com.abhi.githubbrowser.githubapi.network.GitHubApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeGitHubApi @Inject constructor(): GitHubApi {
    var repos = listOf<RepoApiModel>()

    override suspend fun getTopRepositories(): List<RepoApiModel> {
        return repos
    }
}