package com.noox.checklist.superzings.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.noox.checklist.R
import com.noox.checklist.core.extensions.initBinding
import com.noox.checklist.core.extensions.initNavigationWith
import com.noox.checklist.databinding.ActivitySuperZingsBinding

class SuperZingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperZingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initBinding(R.layout.activity_super_zings)

        initNavigationWith(SuperZingsFragment.newInstance())
    }

    fun showProgress() {
        binding.progress.visibility = View.VISIBLE
    }

    fun hideProgress() {
        binding.progress.visibility = View.GONE
    }
}
