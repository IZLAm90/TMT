package com.patient.tmt.helper

import android.Manifest
import android.app.Activity
import android.app.ActivityManager
import android.app.DatePickerDialog
import android.content.Context
import android.content.Context.TELEPHONY_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Parcelable
import android.telephony.TelephonyManager
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.HttpException
import com.patient.data.cashe.PreferencesGateway
import java.text.SimpleDateFormat
import java.util.*

inline fun <reified T : Any> PreferencesGateway.saveValue(key: String, value: T) {
    save(key, value)
}

inline fun <reified T : Any> PreferencesGateway.updateValue(key: String, value: T) {
    update(key, value)
}

inline fun <reified T : Any> PreferencesGateway.getValue(key: String, defaultValue: T): T? {
    return load(key, defaultValue)
}

fun String.isValidEmail(): Boolean {
    val emailRegex = Regex(pattern = "^[^\\s].+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$")
    return matches(emailRegex)
}

fun EditText.isValidInput(): Boolean {
    val input = text.toString().trim()
    return input.isNotEmpty() && !input.startsWith(" ")
}

fun EditText.isValidEmail(): Boolean {
    val email = text.toString().trim()
    val emailRegex = Regex(pattern = "^[^\\s].+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$")
    return email.matches(emailRegex)
}

fun EditText.isSaudiPhoneNumber(): Boolean {
    val phoneNumber = text.toString().trim()
    val saudiPhoneNumberRegex = Regex(pattern = "^\\+?966\\d{9}$")
    return phoneNumber.matches(saudiPhoneNumberRegex)
}

fun String.isStrongPassword(): Boolean {
    val passwordRegex = Regex(pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}\$")
    return matches(passwordRegex)
}

private const val TAG = "Extentions"
fun ImageView.loadImage(image: String) {
    Glide.with(this.context).load(image).into(this)
}

fun TextView.setTextWithDifferentColors(text: String, vararg colors: Int) {
    val spannableString = SpannableString(text)
    val words = text.trim().split("\\s+".toRegex())
    var colorIndex = 0
    for (word in words) {
        val color = colors[colorIndex % colors.size]
        val startIndex = text.indexOf(word)
        val endIndex = startIndex + word.length
        if (startIndex >= 0) {
            spannableString.setSpan(
                ForegroundColorSpan(color),
                startIndex,
                endIndex,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        colorIndex++
    }
    this.text = spannableString
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
fun Activity.isPermissionSMSGranted(): Boolean {
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

fun Context.getCurrentPhoneNumber() {
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
        val phoneNumber = telephonyManager.line1Number
        Log.e("mmmmmmm", phoneNumber?.toString() ?: "")

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
        Log.e(TAG, "getCurrentRamSize: ")
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
fun showDialogDate(context: Context,selectionDate:String? ,dateSelected: DatePickerDialog.OnDateSetListener): DatePickerDialog {
    var calendar: Calendar = Calendar.getInstance()
    if (selectionDate!=null){
        val date= SimpleDateFormat(DateAndTimeFormateUtil.formteDatayyyyMMdd).parse(selectionDate)
        calendar.time=date!!

    }

    val dialog = DatePickerDialog(
        context,
        dateSelected,
        calendar[Calendar.YEAR],
        calendar[Calendar.MONTH],
        calendar[Calendar.DAY_OF_MONTH]
    )

    return dialog
}