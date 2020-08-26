package com.abhi.repository

import com.abhi.githubbrowser.githubapi.model.RepoApiModel
import com.abhi.githubbrowser.githubapi.model.UserApiModel
import com.abhi.githubbrowser.testing.app.githubapi.FakeGitHubApi
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking


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
    private val fakeGithubApi = FakeGitHubApi().apply { repos = listOf(fakeRepoApiModel) }

    @Before
    fun setUp() {
        appRepository = AppRepository(fakeGithubApi)

    }

    @Test
    fun successfulQuery() {
        val topRepos = runBlocking { appRepository.getTopRepos() }
        assertThat(topRepos.size).isEqualTo(1)
        assertThat(topRepos[0]).isEqualTo(fakeRepoApiModel)
    }
}
