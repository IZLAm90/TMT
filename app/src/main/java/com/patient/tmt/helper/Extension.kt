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
