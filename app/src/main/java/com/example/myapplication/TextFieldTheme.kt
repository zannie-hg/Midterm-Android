package com.example.myapplication

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.myapplication.ui.theme.Black
import com.example.myapplication.ui.theme.focusedTextFieldText
import com.example.myapplication.ui.theme.textFiledContainer
import com.example.myapplication.ui.theme.unfocusedTextFieldText
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TextFieldTheme(

    modifier: Modifier=Modifier,
    label:String,
    trailing:String,
    type: String = "text"
){
    var text by remember { mutableStateOf("") }
    val uiColor=if (isSystemInDarkTheme()) Color.White else Black
    TextField(
        modifier=modifier,
        value = text, onValueChange = {text = it},
        label={
            Text(text = label, style=MaterialTheme.typography.labelMedium, color= uiColor)
        },
        colors=TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFiledContainer,
            focusedContainerColor = MaterialTheme.colorScheme.textFiledContainer,

        ),
        visualTransformation = if (type == "password") {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        trailingIcon={
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = trailing,
                    style=MaterialTheme.typography.labelMedium.copy(fontWeight  = FontWeight.Medium),
                    color=uiColor
                )

            }
        }
    )
}