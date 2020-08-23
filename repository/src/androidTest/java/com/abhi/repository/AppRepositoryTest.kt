package com.abhi.repository

import com.abhi.githubbrowser.githubapi.model.RepoApiModel
import com.abhi.githubbrowser.githubapi.model.UserApiModel
import com.abhi.githubbrowser.githubapi.network.GitHubApi
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat


private val fakeRepoApiModel = RepoApiModel(
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

class AppRepositoryTest {

    private lateinit var appRepository: AppRepository
    private val fakeGithubApi = FakeGithubApi()
    @Before
    fun setUp() {
        appRepository = AppRepository(fakeGithubApi)

    }

    @Test
    fun successfulQuery() {
        val topRepos = appRepository.getTopRepos()
        assertThat(topRepos.size).isEqualTo(1)
        assertThat(topRepos[0]).isEqualTo(fakeRepoApiModel)
    }
}

private class FakeGithubApi: GitHubApi {
    override fun getTopRepositories(): List<RepoApiModel> {
        return listOf(fakeRepoApiModel)
    }
}