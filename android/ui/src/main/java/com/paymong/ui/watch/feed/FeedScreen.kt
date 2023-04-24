package com.paymong.ui.watch.feed

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.wear.compose.material.*
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.paymong.common.navigation.WatchNavItem
import com.paymong.domain.watch.feed.FeedBuyListViewModel
import com.paymong.domain.watch.feed.FeedViewModel
import com.paymong.ui.theme.PaymongTheme

@Composable
fun Feed(navController: NavHostController) {
    val viewModel: FeedViewModel = viewModel()
    FeedUI(navController, viewModel)
}

@Composable
fun FeedUI(
    navController: NavHostController,
    viewModel: FeedViewModel
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { navController.navigate(WatchNavItem.FeedBuyList.route + "/RICE") },
                modifier = Modifier.size(width = 200.dp, height = 100.dp).weight(1f),
                shape = RectangleShape
            ) {
                Text(text = "밥")
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier

                .fillMaxWidth()
                .padding(top = 5.dp)
        ) {
            Button(
                onClick = { navController.navigate(WatchNavItem.FeedBuyList.route + "/SNACK") },
                modifier = Modifier.size(width = 200.dp, height = 100.dp).weight(1f),
                shape = RectangleShape
            ) {
                Text(text = "간식")
            }
        }
    }
}



@Preview(device = Devices.WEAR_OS_LARGE_ROUND, showSystemUi = true)
@Composable
fun FeedPreview() {
    val navController = rememberSwipeDismissableNavController()
    PaymongTheme {
        Feed(navController)
    }
}