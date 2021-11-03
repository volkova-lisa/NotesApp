package quizapp.volkova.notesapp

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId = "notification_channel"
const val channelName = "name"
class MyFirebaseMessagingService : FirebaseMessagingService(){

    //generate notific
    //attach notif with custom dialog
    //showthe notific

//    override fun onMessageReceived(p0: RemoteMessage) {
//        if(p0.notification != null){
//            generateNotification(p0.notification!!.title!!, p0.notification!!.body!!)
//        }
//    }
//
//    @SuppressLint("RemoteViewLayout")
//    fun getRemoteView(title: String, message: String) : RemoteViews {
//        val remoteView = RemoteViews("quizapp.volkova.notesapp", R.layout.notification)
//        remoteView.setTextViewText(R.id.text, title)
//        return remoteView
//    }
//
//    fun generateNotification(title: String, message: String) {
//        val intent = Intent(this, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
//
//        //channel id channel name
//        var builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelId)
//            .setSmallIcon(R.drawable.ic_stat_ic_notification)
//            .setAutoCancel(true)
//            .setVibrate(longArrayOf(1000,1000,1000,1000))
//            .setOnlyAlertOnce(true)
//            .setContentIntent(pendingIntent)
//
//        builder = builder.setContent(getRemoteView(title, message))
//        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            val notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
//            notificationManager.createNotificationChannel(notificationChannel)
//        }
//        notificationManager.notify(0, builder.build())
//    }
//
//    override fun onNewToken(token: String) {
//        Log.d(TAG, "----------------------------------------: $token")
//        //sendRegistrationToServer(token)
//    }
}