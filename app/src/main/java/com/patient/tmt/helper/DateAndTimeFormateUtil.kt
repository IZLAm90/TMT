package com.patient.tmt.helper


import com.patient.data.model.Day
import java.lang.Exception
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object DateAndTimeFormateUtil {

    val formteDatayyyyMMdd="yyyy-MM-dd"
    val formteDataddMMyyyy="dd-MM-yyy"
    val formteDateEEEddMMyyyy="EEE dd/MM/yyyy"
    fun formateTimeTo12Hours(input:String?):String?{
        val outputFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
        val inputFormat = SimpleDateFormat("HH:mm:ss",Locale.ENGLISH)
        var date: Date? = null
        var str: String? = ""
        try {
            date = inputFormat.parse(input)
            str = outputFormat.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
        return str
    }

    fun parseDateFormate(
        dateStr: String,
        inputFormatStr: String,
        outputFormatStr: String
    ): String? {
        val outputFormat = SimpleDateFormat(outputFormatStr, Locale.ENGLISH)
        val inputFormat = SimpleDateFormat(inputFormatStr, Locale.ENGLISH)
        var date: Date? = null
        var str: String? = null
        try {
            date = inputFormat.parse(dateStr)
            str = outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return str
    }

    fun getMonthDays(year: Int, month: Int): ArrayList<Day>? {
        val cal = Calendar.getInstance()
        val dayOfSalons: ArrayList<Day> = ArrayList<Day>()
        cal[year, month] = 1
        cal[Calendar.DAY_OF_MONTH] = 1
        val maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        println("MaxDay  $maxDay")
        val df =
            SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val dfDayName = SimpleDateFormat(
            "dd\nEEE",
            Locale("en")
        )
        val calendar = Calendar.getInstance()
        if (year == calendar[Calendar.YEAR] && month == calendar[Calendar.MONTH]) {
            run {
                for (i in calendar[Calendar.DAY_OF_MONTH]..maxDay) {
                    cal[Calendar.DAY_OF_MONTH] = i
                    val day = Day()
                    day.date=df.format(cal.time)
                    val name=dfDayName.format(cal.time).split("\n")
                    day.name=name[1]
                    day.dayNumber=name[0]
                    dayOfSalons.add(day)
                }
            }
        } else {
            for (i in 1..maxDay) {
                cal[Calendar.DAY_OF_MONTH] = i
                val day = Day()
                day.date=df.format(cal.time)
                val name=dfDayName.format(cal.time).split("\n")
                day.name=name[1]
                day.dayNumber=name[0]
                dayOfSalons.add(day)
            }
        }
        return dayOfSalons
    }


}