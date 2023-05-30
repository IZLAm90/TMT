package com.patient.tmt.presentation.fragment.viewpager

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.data.model.ModelMainViewPager
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentViewPagerBinding
import com.patient.tmt.presentation.activity.main.MainActivity
import com.patient.tmt.presentation.adapter.MainViewPageAdapter


class ViewPagerFragment : BaseFragment(R.layout.fragment_view_pager) {
    private lateinit var binding : FragmentViewPagerBinding
    private val list : ArrayList<ModelMainViewPager> = arrayListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentViewPagerBinding.bind(view)
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        binding.apply {
            list.add(ModelMainViewPager(R.drawable.item_one_view_page,"تحدث مع اطباء مناوبين علي مدار الساعة لمساعدتك انت وعائلتك"))
            list.add(ModelMainViewPager(R.drawable.item_one_view_page,"تحدث مع اطباء مناوبين علي مدار الساعة لمساعدتك انت وعائلتك"))
            list.add(ModelMainViewPager(R.drawable.item_one_view_page,"تحدث مع اطباء مناوبين علي مدار الساعة لمساعدتك انت وعائلتك"))
            list.add(ModelMainViewPager(R.drawable.item_one_view_page,"تحدث مع اطباء مناوبين علي مدار الساعة لمساعدتك انت وعائلتك"))
            list.add(ModelMainViewPager(R.drawable.item_one_view_page,"تحدث مع اطباء مناوبين علي مدار الساعة لمساعدتك انت وعائلتك"))
            list.add(ModelMainViewPager(R.drawable.item_one_view_page,"تحدث مع اطباء مناوبين علي مدار الساعة لمساعدتك انت وعائلتك"))
            val adapter=MainViewPageAdapter()
            mainViewPager.adapter =adapter
            adapter.AddAll(list)
            dotIndicator.setViewPager2(mainViewPager)
            move.setOnClickListener {
             mainViewPager.currentItem  = mainViewPager.currentItem+1
            }
            skip.setOnClickListener {
               startActivity(Intent(requireContext(),MainActivity::class.java))
                activity?.finish()
            }

        }

    }

}