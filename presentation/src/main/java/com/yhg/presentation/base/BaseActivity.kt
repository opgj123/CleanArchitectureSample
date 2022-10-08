package com.yhg.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleObserver

abstract class BaseActivity<T: ViewDataBinding>(@LayoutRes private val layoutId: Int): AppCompatActivity(), LifecycleObserver {

    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        lifecycle.addObserver(this)
        initBindingSetting()
        initObjectSetting()
        initViewSetting()
        initObserverSetting()
    }

    abstract fun initBindingSetting()
    abstract fun initObjectSetting()
    abstract fun initViewSetting()
    abstract fun initObserverSetting()
}