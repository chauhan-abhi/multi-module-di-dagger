package com.abhi.home.di

import com.abhi.appdeps.ApplicationDeps
import com.abhi.appdeps.applicationDeps
import com.abhi.home.HomeFragment
import dagger.Component

@Component(dependencies = [ApplicationDeps::class], modules = [HomeModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(applicationDeps: ApplicationDeps): HomeComponent
    }
}

fun HomeFragment.inject() {
    DaggerHomeComponent.factory().create(requireContext().applicationDeps()).inject(this)
}