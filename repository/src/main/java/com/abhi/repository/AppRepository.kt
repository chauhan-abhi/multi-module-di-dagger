package com.abhi.repository

import com.abhi.githubbrowser.githubapi.network.GitHubApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    private val gitHubApi: GitHubApi
) {

    fun getTopRepos() = gitHubApi.getTopRepositories()
}