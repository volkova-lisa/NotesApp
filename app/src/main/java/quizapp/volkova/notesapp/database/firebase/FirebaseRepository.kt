package quizapp.volkova.notesapp.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import quizapp.volkova.notesapp.database.DataBaseRepository
import quizapp.volkova.notesapp.models.NoteBody
import quizapp.volkova.notesapp.utils.EMAIL
import quizapp.volkova.notesapp.utils.PASS

class FirebaseRepository: DataBaseRepository {

    private val mAuth = FirebaseAuth.getInstance()

    override val allNotes: LiveData<List<NoteBody>> = NotesLiveData()

    override suspend fun insert(noteBody: NoteBody, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(noteBody: NoteBody, onSuccess: () -> Unit) {
        TODO("Not yet implemented")
    }

    override fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(EMAIL, PASS)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(EMAIL, PASS)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }

    }

    override fun signOut() {
        mAuth.signOut()
    }
}