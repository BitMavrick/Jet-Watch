package com.bitmavrick.jet_watch.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.bitmavrick.jet_watch.R

@Composable
fun JetClockIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    val semantics = if (contentDescription != null) {
        Modifier.semantics {
            this.contentDescription = contentDescription
            this.role = Role.Image
        }
    } else {
        Modifier
    }

    Box(modifier = modifier.then(semantics)) {
        Icon(
            painter = painterResource(id = R.drawable.clock_body),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primaryContainer
        )

        Icon(
            painter = painterResource(id = R.drawable.clock_dial),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )

        Icon(
            painter = painterResource(id = R.drawable.clock_number),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.background
        )

        Icon(
            painter = painterResource(id = R.drawable.clock_tick),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primaryContainer
        )

        Icon(
            painter = painterResource(id = R.drawable.man_body),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surface
        )

        Icon(
            painter = painterResource(id = R.drawable.man_dress_bottom),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )

        Icon(
            painter = painterResource(id = R.drawable.man_dress_top),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error
        )
    }
}


@Preview(showBackground = true)
@Composable
fun JetClockIconPreview(){
    JetClockIcon(
        contentDescription = null
    )
}