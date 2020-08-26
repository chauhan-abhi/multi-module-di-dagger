package com.abhi.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhi.di.viewmodel.viewmodel.AppViewModelFactory
import com.abhi.home.databinding.ScreenHomeBinding
import com.abhi.home.di.inject
import com.abhi.home.list.HomeRepoAdapter
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
     * }
     * The component will get created each time onAttach is called
     * which is non ideal. It should mirror the lifecycle of ViewModel
     *
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
        binding.repoList.apply {
            adapter = HomeRepoAdapter()
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        homeViewModel.viewStateUpdates.observe(viewLifecycleOwner, Observer { state ->
            when(state) {
                is HomeViewStateLoading -> handleLoadingState(binding)
                is HomeViewStateLoaded  -> handleLoadedState(state, binding)
                is HomeViewStateError   -> handleErrorState(state, binding)
            }
        })
        return binding.root
    }

    private fun handleErrorState(state: HomeViewStateError, binding: ScreenHomeBinding) {
        binding.repoList.visibility = View.GONE
        binding.errorTextView.text = state.message
        binding.loadingIndicator.visibility = View.VISIBLE

    }

    private fun handleLoadedState(state: HomeViewStateLoaded, binding: ScreenHomeBinding) {
        binding.errorTextView.visibility = View.GONE
        binding.loadingIndicator.visibility = View.GONE

        binding.repoList.visibility = View.VISIBLE
        (binding.repoList.adapter as HomeRepoAdapter).setRepoItems(state.repos)

    }

    private fun handleLoadingState(binding: ScreenHomeBinding) {
        binding.repoList.visibility = View.GONE
        binding.errorTextView.visibility = View.GONE
        binding.loadingIndicator.visibility = View.VISIBLE
    }
}