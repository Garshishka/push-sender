package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val messageLike = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    val messageBad = Message.builder()
        .putData("action", "BAD")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    val messageNewPost = Message.builder()
        .putData("action", "NEWPOST")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postText": "Я создал новый пост, вот он какой красивый, смотрите, читайте этот текст. Текст вот длинный чтобы в пуше раскрывался, смотрите какой"
        }""".trimIndent())
        .setToken(token)
        .build()

    //FirebaseMessaging.getInstance().send(messageLike)
    //FirebaseMessaging.getInstance().send(messageBad)
    FirebaseMessaging.getInstance().send(messageNewPost)
}