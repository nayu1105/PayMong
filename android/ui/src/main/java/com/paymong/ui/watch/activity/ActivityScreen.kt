package com.paymong.ui.watch.activity

import android.media.SoundPool
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.paymong.common.R
import com.paymong.common.navigation.WatchNavItem
import com.paymong.domain.watch.activity.ActivityViewModel
import com.paymong.ui.theme.PaymongTheme
import com.paymong.ui.theme.dalmoori
import com.paymong.ui.watch.landing.MainBackgroundGif

@Composable
fun Activity(navController: NavHostController) {
    val viewModel: ActivityViewModel = viewModel()
    ActivityUI(navController, viewModel)
}





@Composable
fun ActivityUI(
    navController: NavHostController,
    viewModel: ActivityViewModel
) {

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    val img = painterResource(R.drawable.main_bg)
    Image(painter = img, contentDescription = null, contentScale = ContentScale.Crop)
    MainBackgroundGif()

    if (screenWidthDp < 200) {
        SmallWatch( navController, viewModel)
    }
    else {
        BigWatch( navController, viewModel)
    }



}

@Preview(device = Devices.WEAR_OS_LARGE_ROUND, showSystemUi = true)
@Composable
fun ActivityPreview() {
    val navController = rememberSwipeDismissableNavController()
    PaymongTheme {
        Activity(navController)
    }
}

@Composable
fun SmallWatch(    navController: NavHostController,
                   viewModel: ActivityViewModel ) {

    val soundPool = SoundPool.Builder()
        .setMaxStreams(1) // 동시에 재생 가능한 스트림의 최대 수
        .build()
    val context = LocalContext.current
    val buttonSound = soundPool.load(context, com.paymong.ui.R.raw.button_sound, 1)


    fun ButtonSoundPlay () {
        soundPool.play(buttonSound, 0.5f, 0.5f, 1, 0, 1.0f)
    }


    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,

            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {ButtonSoundPlay(); navController.navigate(WatchNavItem.Training.route) },
                modifier = Modifier.size(width = 200.dp, height = 95.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Text(text = "훈련",
                    fontFamily = dalmoori,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(top= 20.dp)
                    )
            }
        }
        // * Line *
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(5.dp))

        Row(
            horizontalArrangement = Arrangement.Center,

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        ){
            Button(
                onClick = {ButtonSoundPlay(); navController.navigate(WatchNavItem.Walking.route) },
                modifier = Modifier.size(width = 200.dp, height = 100.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Text(text = "산책",
                    fontFamily = dalmoori,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom= 20.dp)
                    )
            }
        }
    }
}

@Composable
fun BigWatch(    navController: NavHostController,
                   viewModel: ActivityViewModel ) {


    val soundPool = SoundPool.Builder()
        .setMaxStreams(1) // 동시에 재생 가능한 스트림의 최대 수
        .build()
    val context = LocalContext.current
    val buttonSound = soundPool.load(context, com.paymong.ui.R.raw.button_sound, 1)


    fun ButtonSoundPlay () {
        soundPool.play(buttonSound, 0.5f, 0.5f, 1, 0, 1.0f)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {ButtonSoundPlay(); navController.navigate(WatchNavItem.Training.route) },
                modifier = Modifier
                    .size(width = 200.dp, height = 100.dp)
                    .weight(1f),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Text(text = "훈련",
                    fontFamily = dalmoori,
                    fontSize = 24.sp)
            }
        }
        // * Line *
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(5.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        ){
            Button(
                onClick = {ButtonSoundPlay(); navController.navigate(WatchNavItem.Walking.route) },
                modifier = Modifier
                    .size(width = 200.dp, height = 100.dp)
                    .weight(1f),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
            ) {
                Text(text = "산책",
                    fontFamily = dalmoori,
                    fontSize = 24.sp)
            }
        }
    }
}
