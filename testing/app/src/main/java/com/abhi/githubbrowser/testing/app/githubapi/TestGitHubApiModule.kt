package com.abhi.githubbrowser.testing.app.githubapi

import com.abhi.githubbrowser.githubapi.network.GitHubApi
import com.abhi.githubbrowser.testing.app.githubapi.FakeGitHubApi
import dagger.Binds
import dagger.Module

@Module
interface TestGitHubApiModule {

    /**
     * Tells dagger when someone injects GitHub Api give
     * them fakeGitHubApi implementation
     */
    @Binds
    fun getGitHubApi(fakeGitHubApi: FakeGitHubApi): GitHubApi
}