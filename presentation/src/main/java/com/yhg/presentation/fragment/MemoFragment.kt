package com.yhg.presentation.fragment

import android.graphics.PorterDuff
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.yhg.domain.model.MemoItem
import com.yhg.presentation.R
import com.yhg.presentation.base.BaseFragment
import com.yhg.presentation.databinding.FragmentMemoBinding
import com.yhg.presentation.utils.EventObserver
import com.yhg.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemoFragment : BaseFragment<FragmentMemoBinding>(R.layout.fragment_memo) {

    private val mainViewModel: MainViewModel by activityViewModels()
    private var memoItem : MemoItem? = null

    override fun initBindingSetting() {}

    override fun initObjectSetting() {}

    override fun initViewSetting() {

        binding.imgBack.setOnClickListener { findNavController().navigateUp() }
        binding.imgTitleDelete.setOnClickListener {
            binding.editTitle.text.clear()
        }

        binding.imgSave.setOnClickListener {
            val title = binding.editTitle.text.toString()
            val content = binding.editContent.text.toString()
            if(title.isNotEmpty()){
                // 편집
                if(memoItem != null){
                    if(memoItem?.title == title.trim() && memoItem?.content == content.trim())
                        findNavController().navigateUp()
                    else{

                    }
                // 새로 만들기
                }else{
                    mainViewModel.insertMemo(title, content)
                }
            }
        }

        binding.imgDelete.setOnClickListener {
            memoItem?.let { memo -> mainViewModel.deleteMemo(memo) }
        }

        binding.editTitle.addTextChangedListener { text ->
            val inputTitle = text?.toString() ?: return@addTextChangedListener
            if(inputTitle.trim().isNotEmpty())
                binding.imgSave.setColorFilter(ContextCompat.getColor(requireContext(),  R.color.white))
            else
                binding.imgSave.setColorFilter(ContextCompat.getColor(requireContext(),  R.color.gray))
        }
    }

    override fun initObserverSetting() {
        mainViewModel.memoData.observe(viewLifecycleOwner, EventObserver{
            memoItem = it
            binding.editTitle.setText(it.title)
            binding.editContent.setText(it.content)
            binding.imgDelete.isVisible = it.title.isNotEmpty()
            binding.imgSave.setColorFilter(ContextCompat.getColor(requireContext(),  R.color.white))
        })

        mainViewModel.memoConfirmText.observe(viewLifecycleOwner, EventObserver{
            val text = if(it == "save") "메모가 저장되었습니다." else "메모가 삭제되었습니다."
            Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
            findNavController().navigateUp()
        })
    }

}