package quizapp.volkova.notesapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes_tables")
data class NoteBody (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val name: String = "",
    @ColumnInfo val text: String = "",
    val idFirebase: String = ""
    ):Serializable