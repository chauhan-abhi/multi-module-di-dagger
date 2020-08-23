package com.abhi.appdeps

import android.content.Context
import com.abhi.repository.AppRepository
import java.lang.IllegalArgumentException

interface ApplicationDeps {

    fun appRepository(): AppRepository
}

/**
 * Allow us to reference the implementation of this
 * with any context.
 * This assumes our Application subclass will implement
 * @see HasApplicationDeps
 * If not implemented throw an error
 */
fun Context.applicationDeps(): ApplicationDeps {
    return (applicationContext as? HasApplicationDeps)?.getApplicationDeps()
        ?: throw  IllegalArgumentException("Application must implement HasApplicationDeps")
}