package com.mario.weather.ui.tuto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mario.weather.R
import com.mario.weather.WeatherAppState
import com.mario.weather.ui.component.AppScaffold
import com.mario.weather.ui.theme.CustomTheme
import com.mario.weather.ui.theme.MyWeatherTheme


@Composable
fun Tuto(appState: WeatherAppState, viewModel: TutoViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    TutoScreen(state)
}

@Composable
fun TutoScreen(state: TutoViewState) {
    AppScaffold(state = state, onDismissErrorDialog = { /*TODO*/ }) { _, _ ->
        TutoContent()
    }
}

@Composable
fun TutoContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(CustomTheme.colors.tuto_gradient),
                shape = RectangleShape,
                alpha = 1.0f
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .padding(horizontal = 30.dp),
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = stringResource(id = R.string.skip),
                    style = CustomTheme.typography.btnTitle1.copy(color = CustomTheme.colors.btn_title1),
                    modifier = Modifier
                        .align(Alignment.End)
                        .height(20.dp)
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxSize()
                    .paint(
                        painterResource(id = R.drawable.bg_oval),
                        contentScale = ContentScale.Fit
                    ),
            ) {
                Spacer(modifier = Modifier.height(81.dp))
                Text(
                    text = stringResource(id = R.string.splash_logo1),
                    style = CustomTheme.typography.heading01.copy(color = CustomTheme.colors.title1),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = stringResource(id = R.string.splash_logo2),
                    style = CustomTheme.typography.heading02.copy(color = CustomTheme.colors.subtitle1),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TutoPreview() {
    MyWeatherTheme {
        TutoContent()
    }
}