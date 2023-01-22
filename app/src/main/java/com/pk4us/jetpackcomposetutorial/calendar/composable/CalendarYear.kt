package com.pk4us.jetpackcomposetutorial.calendar.composable

import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.pk4us.jetpackcomposetutorial.calendar.utils.LogCompositions

@Composable
internal fun CalendarYear(
    year: Int,
    isSelectedYear: Boolean,
    isCurrentYear: Boolean,
    setSelectedYear: (Int) -> Unit
) {
    LogCompositions("CalendarYear")

    if (isSelectedYear) {
        Button(onClick = {
            setSelectedYear(year)
        }) {
            Text("$year", maxLines = 1)
        }
    } else if (isCurrentYear) {
        OutlinedButton(onClick = {
            setSelectedYear(year)
        }) {
            Text("$year", maxLines = 1)
        }
    } else {
        TextButton(onClick = { setSelectedYear(year) }) {
            Text("$year", maxLines = 1)
        }
    }
}
