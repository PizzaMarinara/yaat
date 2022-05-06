package dev.efantini.yaat.ui.shared.elements

import androidx.compose.runtime.Composable
import dev.efantini.yaat.ui.shared.navigation.BaseNavHost
import dev.efantini.yaat.ui.shared.theme.YaatTheme

@Composable
fun MainContent() {
    YaatTheme {
        BaseNavHost()
    }
}
