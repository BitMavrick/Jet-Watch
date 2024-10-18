package com.bitmavrick.jet_watch.ui.permission

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bitmavrick.jet_watch.components.JetClockIcon
import com.bitmavrick.jet_watch.ui.theme.JetWatchTheme

@Composable
fun MainPermissionScreen(
    windowSize: WindowSizeClass,
    primaryText: String?,
    errorText: String?,
    onClickGranted : () -> Unit,
    onClickAppSettings : () -> Unit = {}
){
    Scaffold (
        topBar = {
            TopBar()
        },
        content = { innerPadding ->
            Body(
                windowSize = windowSize,
                padding = innerPadding,
                normalText = primaryText,
                errorText = errorText,
                onClickAppSettings = onClickAppSettings
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    onClickGranted()
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.CheckCircleOutline,
                        contentDescription = ""
                    )
                },
                text = { Text("Allow Access") }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(){
    LargeTopAppBar(
        title = {
            Text(
                text = "Welcome",
                fontSize = 35.sp
            )
        }
    )
}

@Composable
private fun Body(
    windowSize: WindowSizeClass,
    padding: PaddingValues,
    normalText: String?,
    errorText: String?,
    onClickAppSettings: () -> Unit
){
    LazyColumn (
        modifier = Modifier.padding(padding).padding(16.dp)
    ){
        if( windowSize.heightSizeClass != WindowHeightSizeClass.Compact ){
            item{
                Row(
                    modifier = Modifier.height(250.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    JetClockIcon(
                        contentDescription = null
                    )
                }
            }
        }

        item{
            Spacer(Modifier.height(16.dp))

            if(errorText != null){
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
            }else{
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = null
                )
            }

            if(normalText != null){
                Spacer(Modifier.height(16.dp))

                Text(
                    text = normalText,
                )
            }

            if(errorText != null){
                Spacer(Modifier.height(16.dp))

                Text(
                    text = errorText,
                    color = MaterialTheme.colorScheme.error
                )
            }

            Spacer(Modifier.height(22.dp))

            SettingsText(
                onClickAppSettings = onClickAppSettings
            )

            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
private fun SettingsText(
    onClickAppSettings: () -> Unit
){
    BasicText(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.onBackground
                )
            ) {
                append("Grant permission manually from ")
            }

            val link = LinkAnnotation.Clickable(
                tag = "JetpackComposeLink",
                linkInteractionListener = {
                    onClickAppSettings()
                }
            )
            withLink(link) {
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary,
                        textDecoration = TextDecoration.Underline,
                    )
                ) {
                    append("App Settings")
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun MainPermissionScreenPreview(){
    JetWatchTheme {
        MainPermissionScreen(
            windowSize = WindowSizeClass.calculateFromSize(
                size = DpSize(
                    width = 411.dp,
                    height = 850.dp
                )
            ),
            primaryText = "Jet Watch needs to allow notification permission to working properly, even in the background.",
            errorText = null,
            onClickGranted = {}
        )
    }
}


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(
    showBackground = true,
    device = "spec:width=411dp,height=850dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape"
)
@Composable
fun MainPermissionScreenLandscapePreview() {
    JetWatchTheme {
        MainPermissionScreen(
            windowSize = WindowSizeClass.calculateFromSize(
                size = DpSize(
                    width = 850.dp,
                    height = 411.dp
                )
            ),
            primaryText = "Jet Watch needs to allow notification permission to working properly, even in the background.",
            errorText = null,
            onClickGranted = {}
        )
    }
}