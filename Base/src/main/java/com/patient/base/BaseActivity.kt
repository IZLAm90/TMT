package com.patient.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.patient.base.databinding.ActivityBaseBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BaseActivity (private val layoutResource : Int) : AppCompatActivity() {
    private var viewBase : ActivityBaseBinding ? =null
    var savedInstanceState: Bundle? = null


    open fun setActions() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBase=ActivityBaseBinding.inflate(layoutInflater)
        setContentView(viewBase?.root)
        val activityView = LayoutInflater.from(this)
            .inflate(layoutResource, viewBase?.flContent, false) as ViewGroup
        viewBase?.flContent?.addView(activityView)

        //setContentView(layoutResource)
        this.savedInstanceState = savedInstanceState
//        setActions()
//        observeUnAuthorized()
    }

    fun showProgressFullScreen() {
        inflateLayout(R.layout.progress_dialog)

    }
    fun hideProgressFullScreen(res: Int) {
        inflateMain(res)
    }
    private fun inflateLayout(progressRes: Int) {
        //viewBase?.flProgress?.show()
        //viewBase?.flContent?.removeAllViews()
        val progressViewRes = progressRes
        val progress = LayoutInflater.from(this)
            .inflate(progressViewRes, viewBase?.flContent, false) as ViewGroup
        viewBase?.flContent?.addView(progress)
    }
    private fun inflateMain(layoutResource: Int) {
        //viewBase?.flProgress?.show()
        viewBase?.flContent?.removeAllViewsInLayout()

        val progress = LayoutInflater.from(this)
            .inflate(layoutResource, viewBase?.flContent, false) as ViewGroup
        viewBase?.flContent?.addView(progress)
    }

//    fun handleErrorGeneral(th: Throwable, func: (() -> Unit)? = null): CustomErrorThrow? {
//        //Log.e("error",th.message.toString())
//        th.printStackTrace()
//
//        when (th.message) {
//            /*  Constants_Api.ERROR_API.BAD_REQUEST -> {
//                  ErrorDialog.show(this, getString(R.string.some_error))
//              }
//              Constants_Api.ERROR_API.NOT_FOUND -> {
//                  ErrorDialog.show(this, getString(R.string.some_error))
//              }
//              Constants_Api.ERROR_API.UNAUTHRIZED -> {
//                  baseViewModel.getBaseRepository(this).logout().also { handleUnAuthorized() }
//
//              }
//              Constants_Api.ERROR_API.MAINTENANCE -> {
//                  handleMaintenance()
//              }
//              Constants_Api.ERROR_API.CONNECTION_ERROR -> {
//                  NoInternetDialog.show(this@BaseActivity)
//              }
//
//              else -> {
//                  //ErrorDialog.show(this, getString(R.string.some_error))
//                  if (th.cause is CustomErrorThrow) {
//                      val cause = th.cause as CustomErrorThrow
//                      //ErrorDialog.show(this, cause.value)
//                      return cause
//
//                  } else {
//                      ErrorDialog.show(this, th.message!!)
//                  }
//              }*/
//        }
//        return null
//    }

    override fun onDestroy() {
        super.onDestroy()
        viewBase = null
    }
//    private fun observeUnAuthorized() {
//        GlobalScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                baseViewModel.unAuthorizedFlow
//                    .collect {
//
//                    }
//            }
//        }
//    }

//    fun handleStateFlow(
//        userFlow: StateFlow<NetWorkState>,
//        onShowProgress: (() -> Unit)? = null,
//        onHideProgress: (() -> Unit)? = null,
//        onSuccess: (data: Any) -> Unit,
//        onError: ((th: Throwable) -> Unit)? = null
//    ) {
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                userFlow.collectLatest { networkState ->
//
//                    when (networkState) {
//
//                        is NetWorkState.Success<*> -> {
//                            onSuccess(networkState.data!!)
//                        }
//                        is NetWorkState.Error -> {
//                            if (onError == null) handleErrorGeneral(networkState.th) else onError(
//                                networkState.th
//                            )
//
//                        }
//                    }
//                }
//            }
//        }
//    }

//    fun handleSharedFlow(
//        userFlow: SharedFlow<NetWorkState>,
//        onShowProgress: (() -> Unit)? = null,
//        onHideProgress: (() -> Unit)? = null,
//        onSuccess: (data: Any) -> Unit,
//        onError: ((th: Throwable) -> Unit)? = null
//    ) {
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                userFlow.collect { networkState ->
//                    when (networkState) {
//                        is NetWorkState.Success<*> -> {
//                            onSuccess(networkState.data!!)
//                        }
//
//                        is NetWorkState.Error -> {
//                            if (onError == null) handleErrorGeneral(networkState.th) else onError(
//                                networkState.th
//                            )
//                        }
//
//                        else -> {
//                        }
//                    }
//                }
//            }
//        }
//    }

    fun hideKeyboard() {
        lifecycleScope.launch(Dispatchers.Main) {
            delay(300)
            currentFocus?.let {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(it.windowToken, 0)
            }
        }
    }
}