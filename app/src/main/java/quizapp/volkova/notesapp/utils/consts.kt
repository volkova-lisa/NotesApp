package quizapp.volkova.notesapp.utils

import quizapp.volkova.notesapp.MainActivity
import quizapp.volkova.notesapp.database.DataBaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY:DataBaseRepository
const val TYPE_DATABASE = "type database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
const val ID_FIREBASE = "id_firebase"
const val NAME = "name"
const val TEXT = "text"
lateinit var EMAIL: String
lateinit var PASS: String