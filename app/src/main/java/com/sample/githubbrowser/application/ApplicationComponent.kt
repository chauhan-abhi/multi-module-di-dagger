package com.sample.githubbrowser.application

import android.content.Context
import com.abhi.appdeps.ApplicationDeps
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
 *
 * @see ApplicationDeps -> extending this allow dagger to recognize heirarchy of
 * interfaces and understand ApplicationComponent can still provide appRepository
 */
@Singleton
@Component(modules = [GitHubApiModule::class])
interface ApplicationComponent: ApplicationDeps {

    /**
     * Any other components depending on AppComponent will
     * now be able to inject AppRepository
     */
    //fun appRepository(): AppRepository
    // can be removed since it is now covered in AppDeps interface


    @Component.Factory
    interface Factory {

        // Takes in Application context and binds it to dependency graph
        // Dagger will generate the implementation of the interface
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}