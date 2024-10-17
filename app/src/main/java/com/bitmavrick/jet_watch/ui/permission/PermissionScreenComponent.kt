package com.bitmavrick.jet_watch.ui.permission

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bitmavrick.jet_watch.components.JetClockIcon

@Composable
fun MainPermissionScreen(
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
                        imageVector = Icons.Default.Notifications,
                        contentDescription = ""
                    )
                },
                text = { Text("Grant Access") }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(){
    LargeTopAppBar(
        title = { Text("Welcome") }
    )
}

@Composable
private fun Body(
    padding: PaddingValues,
    normalText: String?,
    errorText: String?,
    onClickAppSettings: () -> Unit
){
    val annotatedText = buildAnnotatedString {
        append("Grant permission manually from ")

        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline,
            )
        ) {
            append("App settings")
        }
    }

    LazyColumn (
        modifier = Modifier.padding(padding).padding(16.dp)
    ){
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

            ClickableText(
                text = annotatedText,
                onClick = { offset ->
                    val startIndex = annotatedText.indexOf("App settings")
                    val endIndex = startIndex + "App settings".length
                    if (offset in startIndex until endIndex) {
                        onClickAppSettings()
                    }
                },
            )

            Spacer(Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPermissionScreenPreview(){
    MainPermissionScreen(
        primaryText = "Jet Watch needs to allow notification permission to working properly, even in the background.",
        errorText = null,
        onClickGranted = {}
    )
}