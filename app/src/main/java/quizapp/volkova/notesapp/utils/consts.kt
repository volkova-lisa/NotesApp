package quizapp.volkova.notesapp.utils

import quizapp.volkova.notesapp.MainActivity
import quizapp.volkova.notesapp.database.DataBaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY:DataBaseRepository
const val TYPE_DATABASE = "type database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
lateinit var EMAIL: String
lateinit var PASS: String