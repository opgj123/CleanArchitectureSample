package com.yhg.presentation.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import com.yhg.presentation.R
import com.yhg.presentation.base.BaseFragment
import com.yhg.presentation.databinding.FragmentMainBinding
import com.yhg.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mainViewModel: MainViewModel by viewModels()

    override fun initBindingSetting() {}

    override fun initObjectSetting() {

    }

    override fun initViewSetting() {
        binding.btnAdd.setOnClickListener {
            Log.d("LOGD", "test")
        }
    }

    override fun initObserverSetting() {

    }

}