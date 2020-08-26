package com.abhi.githubbrowser.testing.app

import android.content.Context
import com.abhi.githubbrowser.appcomponent.ApplicationComponent
import com.abhi.githubbrowser.testing.app.githubapi.FakeGitHubApi
import com.abhi.githubbrowser.testing.app.githubapi.TestGitHubApiModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestGitHubApiModule::class])
interface TestApplicationComponent: ApplicationComponent {

    fun gitHubApi() : FakeGitHubApi

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): TestApplicationComponent
    }
}