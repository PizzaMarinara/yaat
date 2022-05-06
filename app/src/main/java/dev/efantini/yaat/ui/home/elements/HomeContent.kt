package dev.efantini.yaat.ui.home.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import dev.efantini.yaat.ui.home.HomeViewModel

@Composable
fun HomeContent(viewModel: HomeViewModel) {
    Surface {
        Column {
            NumberBox(viewModel.homeUiState.name)
            Button(onClick = {
                viewModel.setName(Math.random().toString())
            }) {
                Text(text = "Boom")
            }
        }
    }
}
