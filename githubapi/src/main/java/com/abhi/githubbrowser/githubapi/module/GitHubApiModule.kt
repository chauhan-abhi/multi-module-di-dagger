package com.abhi.githubbrowser.githubapi.module

import com.abhi.githubbrowser.githubapi.network.GitHubApi
import com.abhi.githubbrowser.githubapi.network.MockGitHubApi
import dagger.Binds
import dagger.Module

@Module
interface GitHubApiModule {


    /**
     * The function tells Dagger whenever somenone requests
     * @see GitHubApi -> give them
     * @see MockGitHubApi implementation
     *
     * Here we are binding the implementation given in the function arguments to
     * the type declared in the return type ie., GitHubApi
     *
     * However using @Binds annotation requires us to make
     * the argument(MockGitHubApi) injectable
     */

    @Binds
    fun bindGitHubApi(mockGitHunApi: MockGitHubApi): GitHubApi
}