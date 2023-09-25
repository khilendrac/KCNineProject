package com.example.kcnineproject.utilities

import com.example.kcnineproject.utilities.Constants.DATE_FORMATTER_PATTERN
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
/*
Extension functions which are easy to use when needed.
 */


fun Long.getFormattedDate(): String {
    val formatter = SimpleDateFormat(DATE_FORMATTER_PATTERN, Locale.getDefault())
    val date = Date(this)
    return formatter.format(date)
}