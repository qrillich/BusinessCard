package tech.qrillich.business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.qrillich.business_card.ui.theme.BusinessCardTheme


val largeTextStyle: TextStyle = TextStyle(
    color = Color.LightGray,
    fontSize = 32.sp,
    fontWeight = FontWeight.Light
)

val smallTextStyle: TextStyle = TextStyle(
    color = Color.LightGray,
    fontSize = 16.sp,
    fontWeight = FontWeight.Light
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    BusinessCard(modifier = Modifier.padding(it))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = stringResource(id = R.string.android_logo_content_description),
                modifier = Modifier.size(150.dp)
            )
            Text(
                text = stringResource(id = R.string.full_name),
                style = largeTextStyle
            )
            Text(
                text = stringResource(id = R.string.title),
                style = smallTextStyle
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            CardItem(
                text = stringResource(id = R.string.phone),
                imageVector = Icons.Rounded.Call
            )
            CardItem(
                text = stringResource(id = R.string.nickname),
                imageVector = Icons.Rounded.Share
            )
            CardItem(
                text = stringResource(id = R.string.email),
                imageVector = Icons.Rounded.Email
            )
        }
    }
}

@Composable
fun CardItem(text: String, imageVector: ImageVector) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = imageVector,
            colorFilter = ColorFilter.lighting(Color.White, Color.White),
            contentDescription = stringResource(id = R.string.material_icon_content_description)
        )
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            text = text,
            style = smallTextStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
