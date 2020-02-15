package com.noox.checklist.superzings.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.noox.checklist.R
import com.noox.checklist.core.model.SuperZing
import com.noox.checklist.core.ui.BaseFragment
import com.noox.checklist.databinding.FragmentSuperZingsBinding
import com.noox.checklist.superzings.ui.SuperZingsViewModel.ViewState.Loading
import com.noox.checklist.superzings.ui.SuperZingsViewModel.ViewState.Success
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuperZingsFragment : BaseFragment() {

    companion object {
        fun newInstance() = SuperZingsFragment()
    }

    private lateinit var binding: FragmentSuperZingsBinding
    private val viewModel by viewModel<SuperZingsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_super_zings, container,false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initViews() {
        binding.items.layoutManager = GridLayoutManager(activity, 2)
    }

    private fun initListeners() {
        viewModel.state.observe(viewLifecycleOwner, Observer { render(it) })
    }

    private fun render(viewState: SuperZingsViewModel.ViewState) {
        when (viewState) {
            is Loading -> renderLoadingState()
            is Success -> renderSuccessState(viewState.items)
        }
    }

    private fun renderLoadingState() {
        showProgress()
    }

    private fun renderSuccessState(items: List<SuperZing>) {
        hideProgress()
        binding.items.adapter = SuperZingsAdapter(items)
    }

    private fun showProgress() {
        (activity as SuperZingsActivity).showProgress()
    }

    private fun hideProgress() {
        (activity as SuperZingsActivity).hideProgress()
    }
}