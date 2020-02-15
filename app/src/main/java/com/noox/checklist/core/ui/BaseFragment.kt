package com.noox.checklist.core.ui

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    protected fun showError(@StringRes resId: Int) {
        val context = context ?: return
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show()
    }

}