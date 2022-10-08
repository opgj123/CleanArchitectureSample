package com.yhg.presentation.activity

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.yhg.presentation.R
import com.yhg.presentation.base.BaseActivity
import com.yhg.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    lateinit var navController: NavController

    override fun initBindingSetting() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.frg_content) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun initObjectSetting() {

    }

    override fun initViewSetting() {

    }

    override fun initObserverSetting() {

    }


}