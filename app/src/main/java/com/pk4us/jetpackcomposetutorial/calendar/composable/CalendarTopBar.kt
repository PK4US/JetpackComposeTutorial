package com.pk4us.jetpackcomposetutorial.calendar.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.calendar.utils.LogCompositions
import java.text.DateFormat
import java.time.LocalDate
import java.time.OffsetTime
import java.util.*

@Composable
internal fun CalendarTopBar(selectedDate: LocalDate) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        LogCompositions("CalendarTopBar")

        val dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT)
        Text(
            text = dateFormatter.format(
                Date.from(selectedDate.atTime(OffsetTime.now()).toInstant())
            ),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}
