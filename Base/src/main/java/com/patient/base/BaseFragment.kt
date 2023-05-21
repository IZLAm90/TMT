package com.patient.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BaseFragment(private val layout: Int) : Fragment() {
    private var fragmentView: ViewGroup? = null
    private var baseActivity: BaseActivity? = null
    var savedInstanceState: Bundle? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(layout, container, false)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        fragmentView = null
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.baseActivity = activity
        }
    }

    protected fun showProgressFullScreen() {
        baseActivity?.showProgressFullScreen()
    }

    protected fun hideProgressFullScreen(fragmentRecords: Int) {
        baseActivity?.hideProgressFullScreen(fragmentRecords)
    }

    override fun onDetach() {
        super.onDetach()
        baseActivity = null
    }


//    protected fun handleErrorGeneral(th: Throwable, func: (() -> Unit)? = null): CustomErrorThrow? {
//        return baseActivity?.handleErrorGeneral(th, func)
//    }


    fun <T> Fragment.handleFlow(
        userFlow: Flow<T>,
        lifeCycle: Lifecycle.State = Lifecycle.State.STARTED,
        onAction: (flow: T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(lifeCycle) {
                userFlow.collect { flow ->
                    onAction.invoke(flow)
                }
            }
        }
    }

//    fun Fragment.handleSharedFlow(
//        userFlow: SharedFlow<NetWorkState>,
//        onShowProgress: (() -> Unit)? = null,
//        onHideProgress: (() -> Unit)? = null,
//        onSuccess: (data: Any) -> Unit,
//        onError: ((th: Throwable) -> Unit)? = null
//    ) {
//        (activity as BaseActivity).handleSharedFlow(userFlow, onShowProgress, onHideProgress, onSuccess,onError)
//    }

 /*   fun Fragment.handleStateFlow(
        userFlow: StateFlow<NetWorkState>,
        onShowProgress: (() -> Unit)? = null,
        onHideProgress: (() -> Unit)? = null,
        onSuccess: (data: Any) -> Unit,
        onError: ((th: Throwable) -> Unit)? = null
    ) {
        (activity as BaseActivity).handleStateFlow(userFlow, onShowProgress, onHideProgress, onSuccess,onError)
    }*/



    fun hideKeyboard(){
        baseActivity?.hideKeyboard()
    }
}