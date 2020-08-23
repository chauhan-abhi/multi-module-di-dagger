package com.sample.githubbrowser.application

import android.content.Context
import com.abhi.githubbrowser.githubapi.module.GitHubApiModule
import com.abhi.githubbrowser.githubapi.network.GitHubApi
import com.abhi.repository.AppRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


/**
 * modules = [GitHubApiModule::class] -> Anything being able to inject the
 * @see ApplicationComponent will be able to inject the
 * @see GitHubApi
 */
@Singleton
@Component(modules = [GitHubApiModule::class])
interface ApplicationComponent {

    /**
     * Any other components depending on AppComponent will
     * now be able to inject AppRepository
     */
    fun appRepository(): AppRepository

    @Component.Factory
    interface Factory {

        // Takes in Application context and binds it to dependency graph
        // Dagger will generate the implementation of the interface
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}