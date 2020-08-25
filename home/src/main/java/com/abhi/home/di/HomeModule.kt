package com.abhi.home.di

import androidx.lifecycle.ViewModel
import com.abhi.di.viewmodel.viewmodel.ViewModelKey
import com.abhi.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindViewModel(homeViewModel: HomeViewModel): ViewModel
}