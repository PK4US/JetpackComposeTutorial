package com.pk4us.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcomposetutorial.ui.theme.Material3AppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    TextFieldExample0()
                    Spacer(modifier = Modifier.size(20.dp))
                    TextFieldExample1()
                    Spacer(modifier = Modifier.size(20.dp))
                    TextFieldExample2()
                    Spacer(modifier = Modifier.size(20.dp))
                    TextFieldExample3()
                    Spacer(modifier = Modifier.size(20.dp))
                    TextFieldExample4()
                    Spacer(modifier = Modifier.size(20.dp))
                    TextFieldExample5()
                    Spacer(modifier = Modifier.size(20.dp))
                    TextFieldExample6()
                    Spacer(modifier = Modifier.size(20.dp))
                    TextFieldExample7()
                    Spacer(modifier = Modifier.size(20.dp))
                    TextFieldExample8()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextFieldExample0() {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,                                                           // представляет введенное в текстовое поле значение в виде строки, то есть объекта String.
        onValueChange = { text = it },                                          // функция обработки изменения введенного значения.
        modifier = Modifier,                                                    // объект типа Modifier, который задает модификаторы компонента.
        enabled = true,                                                         // устанавливает, будет ли поле доступно для ввода.
        readOnly = false,                                                       // устанавливает, будет ли поле доступно только для чтения.
        textStyle = LocalTextStyle.current,                                     // объект типа TextStyle, который устанавливает стиль текста.
        label = null,                                                           // устанавливает дополнительную метку, которая отображается внутри поля.
        placeholder = null,                                                     // плейсхолдер - временный текст, который отображается внутри поля.
        leadingIcon = null,                                                     // устанавливает иконку, которая отображается перед текстом.
        trailingIcon = null,                                                    // устанавливает иконку, которая отображается после текста.
        isError = false,                                                        // указывает, является ли текущее введенное в поле значение некорректным.
        visualTransformation = VisualTransformation.None,                       // объект типа VisualTransformation, который задает визуальные трансформации для вводимого текста.
        keyboardOptions = KeyboardOptions.Default,                              // объект KeyboardOptions, который задает параметры клавиатуры (например, ее тип).
        keyboardActions = KeyboardActions(),                                    // задает набор функций, которые вызываются в ответ на некоторые действия пользователя.
        singleLine = false,                                                     // устанавливает, будет ли текст однострочным.
        maxLines = Int.MAX_VALUE,                                               // задает максимальное количество строк в поле.
        interactionSource = remember { MutableInteractionSource() },            // задает поток взаимодействий для поля ввода.
        shape = MaterialTheme.shapes.small.copy(                                // задает форму для поля ввода.
            bottomEnd = ZeroCornerSize,
            bottomStart = ZeroCornerSize
        ),
        colors = TextFieldDefaults.textFieldColors()                            // задает цвета для поля ввода.
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextFieldExample1() {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(
            TextFieldValue(
                "example",
                TextRange(0, 7)
            )
        )
    }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextFieldExample2() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        singleLine = true
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextFieldExample3() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Email") },
        placeholder = { Text("example@gmail.com") }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextFieldExample4() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Localized description") },
        trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "Localized description") }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextFieldExample5() {
    val errorMessage = "Text input too long"
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    val charLimit = 10

    fun validate(text: String) {
        isError = text.length > charLimit
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
            validate(text)
        },
        singleLine = true,
        label = { Text(if (isError) "Username*" else "Username") },
        supportingText = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Limit: ${text.length}/$charLimit",
                textAlign = TextAlign.End,
            )
        },
        isError = isError,
        keyboardActions = KeyboardActions { validate(text) },
        modifier = Modifier.semantics {
            // Provide localized description of the error
            if (isError) error(errorMessage)
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextFieldExample6() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        supportingText = {
            Text("Supporting text that is long and perhaps goes onto another line.")
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextFieldExample7() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    TextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        label = { Text("Enter password") },
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
//                val visibilityIcon =
//                    if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
//                // Please provide localized description for accessibility services
//                val description = if (passwordHidden) "Show password" else "Hide password"
//                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Preview
@Composable
fun TextFieldExample8() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        )
    )
}