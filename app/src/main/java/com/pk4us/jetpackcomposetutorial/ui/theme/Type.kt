package com.pk4us.jetpackcomposetutorial.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

val MyCustomTypography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )
)

val Typography.customTitle: TextStyle
    @Composable
    get() {
        return  TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
    }

val TypographyMyCustom = Typography(
    subtitle1 = TextStyle(
        fontFamily = NexaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = NexaFont,
        fontSize = 20.sp,
    )
)
