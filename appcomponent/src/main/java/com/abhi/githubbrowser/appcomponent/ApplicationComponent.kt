package com.abhi.githubbrowser.appcomponent

import android.content.Context
import com.abhi.appdeps.ApplicationDeps
import com.abhi.githubbrowser.githubapi.module.GitHubApiModule
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
 * We are telling Dagger that ApplicationComponent needs to be able to provide AppRepository
 *
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

        // Takes in Application context and binds the context to dependency graph
        // ie objects injected by application component are able to inject Context
        // Dagger will generate the implementation of the interface
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}