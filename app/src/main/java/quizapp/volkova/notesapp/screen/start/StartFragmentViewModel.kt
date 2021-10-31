package quizapp.volkova.notesapp.screen.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import quizapp.volkova.notesapp.database.room.AppRoomDatabase
import quizapp.volkova.notesapp.database.room.AppRoomRepository
import quizapp.volkova.notesapp.utils.REPOSITORY
import quizapp.volkova.notesapp.utils.TYPE_ROOM

class StartFragmentViewModel(app: Application) : AndroidViewModel(app) {
    private val mContext = app

    fun initDataBase(type: String, onSuccess:()->Unit) {
         when(type){
             TYPE_ROOM -> {
                 val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                 REPOSITORY = AppRoomRepository(dao)
                 onSuccess()
             }
         }
    }
}