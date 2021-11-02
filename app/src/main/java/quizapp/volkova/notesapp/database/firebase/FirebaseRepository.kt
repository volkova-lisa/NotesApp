package quizapp.volkova.notesapp.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import quizapp.volkova.notesapp.database.DataBaseRepository
import quizapp.volkova.notesapp.models.NoteBody
import quizapp.volkova.notesapp.utils.*

class FirebaseRepository: DataBaseRepository {

    private val mAuth = FirebaseAuth.getInstance()
    private val mDatabaseReference = FirebaseDatabase.getInstance().reference
        .child(mAuth.currentUser?.uid.toString())

    override val allNotes: LiveData<List<NoteBody>> = NotesLiveData()

    override suspend fun insert(noteBody: NoteBody, onSuccess: () -> Unit) {
        val idNote = mDatabaseReference.push().key.toString()
        val noteMap = hashMapOf<String, Any>()
        noteMap[ID_FIREBASE] = idNote
        noteMap[NAME] = noteBody.name
        noteMap[TEXT] = noteBody.text

        mDatabaseReference.child(idNote)
            .updateChildren(noteMap)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { showToast("Error happened") }
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