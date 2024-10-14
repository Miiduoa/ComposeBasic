package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = stringResource(R.string.author),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // 使用 remember 和 mutableStateOf 來保持狀態
    var x by remember { mutableStateOf(0) }

    Column {
       Row{
        Button(onClick = { x = 0 }) {
            Text(text = "重設 x")
        }

        // 加倍 x 的按鈕
        Button(onClick = { x *= 2 }) {
            Text(text = "兩倍 x")
        }
}
        // 顯示 x 的值，並且使用 clickable 來更新 x
        Text(
            text = x.toString(),
            fontSize = 50.sp,
            modifier = modifier.clickable { x++ }  // 每次點擊 x 加 1
        )

        Row {
            Text(
                text = stringResource(R.string.author),
                fontFamily = FontFamily(Font(R.font.hand)),  // 自訂字體
                fontSize = 50.sp,
                color = Color.Blue,
                modifier = modifier
            )

            Image(
                painter = painterResource(id = R.drawable.tcyang1),
                contentDescription = "顧晉瑋的照片",
                alpha = 0.8f,  // 設置透明度
                modifier = modifier
                    .clip(CircleShape)  // 圓形裁剪
            )
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.tcyang1),
                contentDescription = "丁青法湖照片",
                alpha = 0.8f,
                modifier = modifier.clip(CircleShape)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicTheme {
        Greeting(name = stringResource(R.string.author))
    }
}
