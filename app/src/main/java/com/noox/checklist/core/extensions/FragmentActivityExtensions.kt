package com.noox.checklist.core.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.noox.checklist.R

fun FragmentActivity.initNavigationWith(fragment: Fragment) {
    supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.content, fragment)
        .commit()
}
