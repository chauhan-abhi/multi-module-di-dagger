package com.abhi.home

import com.abhi.home.list.RepoItem

sealed class HomeViewState
object HomeViewStateLoading: HomeViewState()
data class HomeViewStateLoaded(val repos: List<RepoItem>): HomeViewState()
data class HomeViewStateError(val message: String): HomeViewState()
