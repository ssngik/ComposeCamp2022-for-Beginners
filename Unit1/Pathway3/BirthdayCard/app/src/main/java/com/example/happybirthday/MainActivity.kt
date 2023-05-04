
package com.example.happybirthday

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // surface 컴포저블 : 화면 전체를 차지하는 박스 생성.
                Surface(
                    modifier = Modifier.fillMaxSize(), // 사용 가능한 최대 공간 차지
                    color = MaterialTheme.colors.background
                ) {
                    // BirthdayGreetingWithText 컴포저블을 통해 생일 축하 메시지, 축하 인사 표시.
                    BirthdayGreetingWithImage( message = "Happy Birthday Sam!", from = "- from Sangik")
                }
            }
        }
    }
}
// 세로 방향 정렬
@Composable
fun BirthdayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = message,
            fontSize = 36.sp,
        )
        Text(
            text = from,
            fontSize = 24.sp,
        )
    }
}

// modifier : Jetpack Compose UI 요소를 장식하거나 이 요소에 동작을 추가하는 데 사용
// 예를 들어 행이나 텍스트, 버튼에 배경이나 패딩, 동작을 추가할 수 있습니다. 이를 설정하려면 컴포저블이나 레이아웃에서 수정자를 매개변수로 허용해야 합니다.
@Composable
fun BirthdayGreetingWithImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}

// 미리보기
@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage("Happy Birthday Sam!", "- from SangIk")
    }
}

