package com.pk4us.jetpackcomposetutorial.calendar.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.calendar.daterange.DateRange
import com.pk4us.jetpackcomposetutorial.calendar.daterange.DateRangeStep
import com.pk4us.jetpackcomposetutorial.calendar.daterange.rangeTo
import com.pk4us.jetpackcomposetutorial.calendar.model.DateWrapper
import com.pk4us.jetpackcomposetutorial.calendar.utils.LogCompositions
import java.time.LocalDate

@Composable
internal fun CalendarGrid(
    pagerDate: LocalDate,
    dateRange: DateRange,
    selectedDate: LocalDate,
    onSelected: (LocalDate) -> Unit,
    showCurrentMonthOnly: Boolean
) {
    LogCompositions("CalendarGrid")

    val gridSpacing = 4.dp
    val today = LocalDate.now()

    val firstWeekDayOfMonth = pagerDate.dayOfWeek
    val pagerMonth = pagerDate.month

    val gridStartDay = pagerDate
        .minusDays(firstWeekDayOfMonth.value.toLong() - 1)
    val gridEndDay = gridStartDay.plusDays(41)

    val dates = (gridStartDay.rangeTo(gridEndDay) step DateRangeStep.Day()).map {
        val isCurrentMonth = it.month == pagerMonth
        val isCurrentDay = it == today
        val isSelectedDay = it == selectedDate
        val isInDateRange = it in dateRange

        DateWrapper(
            it,
            isSelectedDay,
            isCurrentDay,
            isCurrentMonth,
            isInDateRange,
            showCurrentMonthOnly
        )
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        horizontalArrangement = Arrangement.spacedBy(gridSpacing),
        verticalArrangement = Arrangement.spacedBy(gridSpacing)
    ) {
        items(dates) {
            CalendarDay(
                date = it,
                onSelected = onSelected
            )
        }
    }

}
