package com.patient.tmt.presentation.fragment.chat

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentInboxBinding
import com.patient.tmt.helper.ImagePicker


class InboxFragment : BaseFragment(R.layout.fragment_inbox) {
    private lateinit var binding: FragmentInboxBinding
    private val imagePicker by lazy { ImagePicker(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInboxBinding.bind(view)
        binding.apply {
            back.setOnClickListener {
                findNavController().navigateUp()
            }
            more.setOnClickListener {
            imagePicker.pickFromStorage()
            }
        }
    }

    private fun loadImage(){
        imagePicker._bitmapLivedata.observe(this) {
            if (it != null) {
//                viewModel.sendImage(
//                    token = getUserToken(),
//                    intent.getStringExtra(CONVERSATION).toString(),
//                    it
//                ).observe(this) {
//                    if (isResponseValid(it)) {
//                        it.data?.data?.let {
//                            sendOneToOneMessage(
//                                conversation = uid,
//                                type = "image",
//                                value = it.value.toString()
//                            )
//                        }
//                    }
//                }
            }
        }

    }


}