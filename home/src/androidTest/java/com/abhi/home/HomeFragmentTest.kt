package com.abhi.home

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.abhi.githubbrowser.githubapi.model.RepoApiModel
import com.abhi.githubbrowser.githubapi.model.UserApiModel
import com.abhi.githubbrowser.testing.app.TestApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Before
    fun setUp() {
        val gitHubApi = TestApplication.component.gitHubApi()
        gitHubApi.repos = listOf(
            RepoApiModel(
                id = 1L,
                name = "Home Fragment",
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

    @Test
    fun reposDisplayed() {
        launchFragmentInContainer<HomeFragment>()
        onView(withId(R.id.repo_name)).check(matches(withText("Home Fragment")))
    }
}