package com.yhg.presentation.fragment

import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yhg.presentation.R
import com.yhg.presentation.adapter.MemoListAdapter
import com.yhg.presentation.base.BaseFragment
import com.yhg.presentation.databinding.FragmentMainBinding
import com.yhg.presentation.utils.Utils.Companion.repeatOnStarted
import com.yhg.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var memoListAdapter : MemoListAdapter

    override fun initBindingSetting() {}

    override fun initObjectSetting() {
        memoListAdapter = MemoListAdapter { memoItem ->
            mainViewModel.setMemoId(memoItem)
            findNavController().navigate(R.id.action_frg_memo)
        }
    }

    override fun initViewSetting() {
        binding.rvMemo.adapter = memoListAdapter
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_frg_memo)
        }
    }

    override fun initObserverSetting() {
        repeatOnStarted {
            mainViewModel.getAllMemos().collect{
                memoListAdapter.setItem(it)
            }
        }
    }

}