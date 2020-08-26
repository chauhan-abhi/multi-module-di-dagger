package com.abhi.githubbrowser.githubapi.network

import com.abhi.githubbrowser.githubapi.model.RepoApiModel
import com.abhi.githubbrowser.githubapi.model.UserApiModel
import javax.inject.Inject
import javax.inject.Singleton

interface GitHubApi {
    suspend fun getTopRepositories(): List<RepoApiModel>
}


/**
 * This need to be injectable
 * With this @Inject constructor Dagger can now create GitHubApi
 */
@Singleton
class MockGitHubApi @Inject constructor() : GitHubApi {
    override suspend fun getTopRepositories(): List<RepoApiModel> {
        return listOf(
            RepoApiModel(
                id = 1L,
                name = "Mock Repo",
                description = "Mock Repo Description",
                owner = UserApiModel(id = 1L, login = "dagger"),
                stargazersCount = 1,
                forksCount = 1,
                contributorsUrl = "",
                createdDate = "1/1/2020",
                updatedDate = "4/1/2020"
            ),
            RepoApiModel(
                id = 1L,
                name = "Mock Repo",
                description = "Mock Repo Description",
                owner = UserApiModel(id = 1L, login = "dagger"),
                stargazersCount = 1,
                forksCount = 1,
                contributorsUrl = "",
                createdDate = "1/1/2020",
                updatedDate = "4/1/2020"
            ),
            RepoApiModel(
                id = 1L,
                name = "Mock Repo",
                description = "Mock Repo Description",
                owner = UserApiModel(id = 1L, login = "dagger"),
                stargazersCount = 1,
                forksCount = 1,
                contributorsUrl = "",
                createdDate = "1/1/2020",
                updatedDate = "4/1/2020"
            ),
            RepoApiModel(
                id = 1L,
                name = "Mock Repo",
                description = "Mock Repo Description",
                owner = UserApiModel(id = 1L, login = "dagger"),
                stargazersCount = 1,
                forksCount = 1,
                contributorsUrl = "",
                createdDate = "1/1/2020",
                updatedDate = "4/1/2020"
            )
        )
    }

}