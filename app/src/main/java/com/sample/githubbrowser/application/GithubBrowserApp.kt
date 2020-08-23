package com.sample.githubbrowser.application

import android.app.Application
import com.abhi.appdeps.ApplicationDeps
import com.abhi.appdeps.HasApplicationDeps

class GithubBrowserApp: Application(), HasApplicationDeps {

    private val appComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getApplicationDeps(): ApplicationDeps {
        return appComponent
    }
}