package com.pk4us.jetpackcomposetutorial

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MusicButton()
            }
        }
    }
}

private const val playIcon = 1
private const val loadingBar = 2
private const val pauseIcon = 3

@Preview
@Composable
fun MusicButton(
    viewModel: MyViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    context: Context = LocalContext.current.applicationContext
) {

    // Изначально песня не загружена
    val songLoaded by viewModel.songLoaded.observeAsState(false)

    // Это используется для запоминания значка кнопки
    // Его значения: playIcon, loadingBar и pauseIcon
    // Изначально отображаем playIcon
    var buttonIcon by remember {
        mutableStateOf(playIcon)
    }

    OutlinedButton(
        modifier = Modifier
            .size(72.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(12.dp),
        elevation = ButtonDefaults.elevation(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color(0xFF35898F)
        ),
        border = BorderStroke(0.dp, Color.Transparent),
        onClick = {
            if (!songLoaded) {
                    // Если песня НЕ загружена

                Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()

                viewModel.loadTheSong()

                    // Назначаем buttonIcon для loadingBar, чтобы отображался индикатор прогресса
                buttonIcon = loadingBar
            } else {
                    // Если песня уже загружена

                if (buttonIcon == playIcon) {
                    // Если текущая иконка — play Icon
                    // изменить его на значок паузы
                    buttonIcon = pauseIcon
                } else if (buttonIcon == pauseIcon) {
                    // Если текущая иконка — иконка паузы
                    // изменить его на значок воспроизведения
                    buttonIcon = playIcon
                }
            }
        }
    ) {

        when (buttonIcon) {
            loadingBar -> {
                if (songLoaded) {
                    // Если песня уже загружена
                    // устанавливаем значок паузы
                    buttonIcon = pauseIcon
                } else {
                    // Если песня НЕ загружена
                    // показать индикатор прогресса
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        color = Color.White
                    )
                }
            }
            playIcon -> {
                // Установите значок воспроизведения
                SetButtonIcon1(
                    icon = Icons.Filled.PlayArrow,
                    iconDescription = "Play Song"
                )

                // Если песня загружена, приостановите фактическую песню
                if (songLoaded) {
                    pauseTheSong(context = context)
                }
            }
            pauseIcon -> {
                // Установить значок паузы
                SetButtonIcon1(icon = Icons.Filled.Check, iconDescription = "Pause Song")

                // Если песня загружена, воспроизвести настоящую песню
                if (songLoaded) {
                    playTheSong(context = context)
                }
            }
        }
    }
}

private fun playTheSong(context: Context) {
    // Здесь играем песню
    Log.i("SemicolonSpace", "playTheSong()")
    Toast.makeText(context, "Playing....", Toast.LENGTH_SHORT).show()
}

private fun pauseTheSong(context: Context) {
    // Здесь пауза в песне
    Log.i("SemicolonSpace", "pauseTheSong")
    Toast.makeText(context, "Paused", Toast.LENGTH_SHORT).show()
}

@Composable
private fun SetButtonIcon1(
    icon: ImageVector,
    iconDescription: String
) {
    Icon(
        modifier = Modifier
            .fillMaxSize(),
        imageVector = icon,
        contentDescription = iconDescription,
        tint = Color.White
    )
}

class MyViewModel : ViewModel() {

    // Музыкальная кнопка
    val songLoaded = MutableLiveData<Boolean>()

    fun loadTheSong() {

        viewModelScope.launch {

            withContext(Dispatchers.Default) {
                // Выполняем фоновую задачу, чтобы получить песню
                // После завершения задачи вызываем songLoadedSuccessful()
                // Вместо фоновой задачи я устанавливаю задержку в 4 секунды
                delay(4000)
            }
            songLoadedSuccessful()
        }
    }

    private fun songLoadedSuccessful() {
        songLoaded.value = true
    }
}