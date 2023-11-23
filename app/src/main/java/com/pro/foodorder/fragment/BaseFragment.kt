package com.pro.foodorder.fragment

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    override fun onResume() {
        super.onResume()
        initToolbar()
    }

    protected abstract fun initToolbar()
}