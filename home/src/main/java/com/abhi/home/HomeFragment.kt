package com.abhi.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.abhi.di.viewmodel.viewmodel.AppViewModelFactory
import com.abhi.home.databinding.ScreenHomeBinding
import com.abhi.home.di.inject
import javax.inject.Inject

class HomeFragment: Fragment() {

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, appViewModelFactory)[HomeViewModel::class.java]
    }

    /**
     * fun HomeFragment.inject() {
     *      DaggerHomeComponent.factory()
     *     .create(requireContext().applicationDeps())
     *     .inject(this)
     *
     * The component will get created each time onAttach is called
     * which is non ideal. It should mirror the lifecycle of ViewModel
     *
    }
     */
    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ScreenHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}