package quizapp.volkova.notesapp.database.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import quizapp.volkova.notesapp.models.NoteBody

class NotesLiveData: LiveData<List<NoteBody>>() {
    private val mAuth = FirebaseAuth.getInstance()
    private val mDatabaseReference = FirebaseDatabase.getInstance().reference
        .child(mAuth.currentUser?.uid.toString())
    private val listener = object : ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            value = snapshot.children.map{
                it.getValue(NoteBody::class.java)?: NoteBody()
            }
        }



        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }

    }

    override fun onActive() {
        mDatabaseReference.addValueEventListener(listener)
        super.onActive()
    }

    override fun onInactive() {
        mDatabaseReference.removeEventListener(listener)
        super.onInactive()
    }

}