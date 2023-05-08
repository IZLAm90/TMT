package com.patient.tmt.helper

import android.Manifest
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Context.TELEPHONY_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Parcelable
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.HttpException
import com.patient.tmt.R

private const val TAG = "Extentions"
fun ImageView.loadImage(image: String) {
    Glide.with(this.context).load(image).into(this)
}



fun Context.isMyServiceRunning(serviceClass: Class<*>): Boolean {
    val manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    for (service in manager.getRunningServices(Integer.MAX_VALUE)) {
        if (serviceClass.name.equals(service.service.className)) {
            return true
        }
    }
    return false
}


 @RequiresApi(Build.VERSION_CODES.O)
 fun Activity.requestPermission() {
     requestPermissions(
         arrayOf(
             Manifest.permission.READ_SMS,
             Manifest.permission.READ_PHONE_NUMBERS,
             Manifest.permission.READ_PHONE_STATE
         ), 100
     )
 }

@RequiresApi(Build.VERSION_CODES.O)
fun Activity.isPermissionSMSGranted() : Boolean {
    return ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.READ_PHONE_STATE
    ) == PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.READ_SMS
    ) == PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.READ_PHONE_NUMBERS
    ) == PackageManager.PERMISSION_GRANTED
}



inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}

fun Context.getCurrentPhoneNumber(){
    val telephonyManager = this.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
    val permission = null
    if (ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_SMS
        ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_PHONE_NUMBERS
        ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_PHONE_STATE
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        val phoneNumber =  telephonyManager.line1Number
        Log.e("mmmmmmm",phoneNumber?.toString()?:"")

    }
}

fun ImageView.loadImage(url: String?, size: Int = 1100) {
    kotlin.runCatching {
        val requestBuilder = Glide.with(this.context)
            .asDrawable().sizeMultiplier(0.1f)
        Glide.with(this).load(url)
            .fitCenter()
            .override(context.calculateImageSize())
//            .error(R.drawable.)
            .thumbnail(requestBuilder)
            .into(this)
    }
}

private var currentRamSize = 0L
private var currentImageSize = 0
fun Context.getCurrentRamSize(): Long {
    try {
        if (currentRamSize > 0L)
            return currentRamSize
        val mi = ActivityManager.MemoryInfo()
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?
        activityManager!!.getMemoryInfo(mi)
        var availableMegs: Long = mi.availMem / 0x100000L
        availableMegs -= 700 // safe area
        currentRamSize = availableMegs

        print("ram size " + currentRamSize)
        return availableMegs
    } catch (ex: Exception) {
        Log.e(TAG, "getCurrentRamSize: ", )
        return 1024L
    }
}

private const val IMAGE_SIZE_FACTOR = 150
fun Context.calculateImageSize(): Int {
    if (currentImageSize != 0)
        return currentImageSize
    val ramSize = getCurrentRamSize()
    if (ramSize < 256L)
        return 1 * IMAGE_SIZE_FACTOR // 120 pixel
    if (ramSize < 512L)
        return 2 * IMAGE_SIZE_FACTOR // 240 pixel
    if (ramSize < 766L)
        return 3 * IMAGE_SIZE_FACTOR // 360 pixel
    if (ramSize < 1024L)
        return 4 * IMAGE_SIZE_FACTOR // 480 pixel
    if (ramSize < 1535L)
        return 5 * IMAGE_SIZE_FACTOR // 600 pixel
    if (ramSize < 2048L)
        return 6 * IMAGE_SIZE_FACTOR // 720 pixel
//    if (ramSize < 3073L)
//        return 8 * IMAGE_SIZE_FACTOR // 960 pixel
    return 8 * IMAGE_SIZE_FACTOR // 1080 pixel
}

private fun checkError(throwable: Throwable?) {
    if (throwable == null)
        return
    if (throwable is HttpException) {
        when (throwable.statusCode) {
            401 -> {
            }
            500 -> {

            }
            440 -> {

            }
            else -> {}
        }
    }
}