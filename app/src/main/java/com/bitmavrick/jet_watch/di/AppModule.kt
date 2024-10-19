package com.bitmavrick.jet_watch.di

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.bitmavrick.jet_watch.util.Constants.NOTIFICATION_CHANNEL_ID
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped

@Module
@InstallIn(ServiceComponent::class)
class AppModule {

    @ServiceScoped
    @Provides
    fun providesNotificationBuilder(
        @ApplicationContext context: Context

    ) : NotificationCompat.Builder {
        return NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setContentTitle("Jet Watch")
            .setContentText("00:00:00")
            .setOngoing(true)
    }

    @ServiceScoped
    @Provides
    fun providesNotificationManager(
        @ApplicationContext context: Context
    ) : NotificationManager {
        return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
}