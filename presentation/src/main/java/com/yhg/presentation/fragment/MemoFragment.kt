package com.yhg.presentation.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yhg.presentation.R
import com.yhg.presentation.base.BaseFragment
import com.yhg.presentation.databinding.FragmentMemoBinding
import com.yhg.presentation.utils.Utils.Companion.repeatOnStarted
import com.yhg.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemoFragment : BaseFragment<FragmentMemoBinding>(R.layout.fragment_memo) {

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun initBindingSetting() {

    }

    override fun initObjectSetting() {

    }

    override fun initViewSetting() {
        binding.imgBack.setOnClickListener { findNavController().navigateUp() }
        binding.imgTitleDelete.setOnClickListener {
            binding.editTitle.text.clear()
        }
        binding.imgSave.setOnClickListener {
            val title = binding.editTitle.text.toString()
            val content = binding.editContent.text.toString()
            mainViewModel.insertMemo(title, content)
        }
    }

    override fun initObserverSetting() {
        repeatOnStarted{
            mainViewModel.memoId.observe(viewLifecycleOwner){
                Log.d("LOGD", "memoId : $it")
            }
        }
    }

}