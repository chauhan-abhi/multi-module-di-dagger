package com.abhi.githubbrowser.testing.app

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import com.abhi.appdeps.ApplicationDeps
import com.abhi.appdeps.HasApplicationDeps

class TestApplication: Application(), HasApplicationDeps {

    private lateinit var component: TestApplicationComponent

    companion object {
        val component: TestApplicationComponent
        get() = (InstrumentationRegistry
            .getInstrumentation()
            .targetContext
            .applicationContext as TestApplication)
            .component
    }
    override fun onCreate() {
        super.onCreate()
        component = DaggerTestApplicationComponent.factory().create(this)
    }

    override fun getApplicationDeps(): ApplicationDeps {
        return component
    }
}