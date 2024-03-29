package com.example.myapplication.signin

//import android.text.Layout.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.TextFieldTheme
import com.example.myapplication.ui.theme.BlueGray
import com.example.myapplication.ui.theme.Roboto


@Composable
fun ClickableText(
    annotatedString: AnnotatedString,
    onClick: () -> Unit
) {
    Text(
        text = annotatedString,
        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
        modifier = Modifier.clickable { onClick() }
    )
}

@Composable
fun SignInScreen(onToggle: () -> Unit){
    Surface{
        Column(modifier= Modifier.fillMaxSize()){
            TopSection()
            Column( modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
            ) {
                SignInSection()
                Spacer(modifier = Modifier.height(20.dp))
                BottomSection(onToggle = onToggle)
            }
        }
    }

}

@Composable
private fun BottomSection(onToggle: () -> Unit) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    Box(
        modifier = Modifier
            .fillMaxHeight(fraction = 0.3f)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    )
    {
        ClickableText(
            annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF94A3B8),
                        fontSize = 14.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append("Don't have account?")
                }
                withStyle(
                    style = SpanStyle(
                        color = uiColor,
                        fontSize = 14.sp,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(" ")
                    append("Sign Up")
                }
            },
            onClick = onToggle
        )
    }
}

@Composable
private fun SignInSection() {
    TextFieldTheme(label = "Email", trailing = "", modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(15.dp))

    TextFieldTheme(
        label = "Password",
        trailing = "Fogot?",
        type = "password",
        modifier = Modifier.fillMaxWidth(),
    )
//    Image(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier.size(16.dp) )
    Spacer(modifier = Modifier.height(50.dp))

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = "Sign In",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.45f),

            painter = painterResource(id = R.drawable.shape1),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Row {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.welcome_text),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor,

                    )
                Text(
                    text = stringResource(id = R.string.signin_text),
                    style = MaterialTheme.typography.headlineLarge,
                    color = uiColor
                )
            }
        }

    }
}
