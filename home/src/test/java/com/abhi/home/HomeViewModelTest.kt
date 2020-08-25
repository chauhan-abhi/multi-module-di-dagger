package com.abhi.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.abhi.githubbrowser.githubapi.model.RepoApiModel
import com.abhi.githubbrowser.githubapi.model.UserApiModel
import com.abhi.githubbrowser.githubapi.network.GitHubApi
import com.abhi.home.list.RepoItem
import com.abhi.repository.AppRepository
import org.junit.Before
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test

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
class HomeViewModelTest {

    /** Since Live Data returns on Main Thread and we dont have main looper here
     * Hence this rule runs any runnables scheduled
     */
    @get: Rule
    val taskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: HomeViewModel
    private lateinit var viewStateValue: MutableList<HomeViewState>

    @Before
    fun setUp() {
        val appRepository = AppRepository(FakeGithubApi())
        viewStateValue = mutableListOf()

        viewModel = HomeViewModel(appRepository)
        viewModel.viewStateUpdates.observeForever { viewStateValue.add(it) }
    }

    @Test
    fun `loaded state contains repo models`() {
        assertThat(viewStateValue.size).isEqualTo(1)
        val expectedState = HomeViewStateLoaded(
            repos = listOf(
                RepoItem(
                    name = fakeRepoApiModel.name,
                    description = fakeRepoApiModel.description,
                    starsCount = fakeRepoApiModel.stargazersCount,
                    forkCount = fakeRepoApiModel.forksCount
                )
            )
        )

        assertThat(viewStateValue[0]).isEqualTo(expectedState)
    }
}

private class FakeGithubApi: GitHubApi {
    override fun getTopRepositories(): List<RepoApiModel> {
        return listOf(fakeRepoApiModel)
    }
}