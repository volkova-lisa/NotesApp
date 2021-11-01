package quizapp.volkova.notesapp.screen.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import quizapp.volkova.notesapp.R
import quizapp.volkova.notesapp.databinding.FragmentMainBinding
import quizapp.volkova.notesapp.models.NoteBody
import quizapp.volkova.notesapp.utils.APP_ACTIVITY

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: MainFragmentViewModel

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mainAdapter: MainAdapter
    private lateinit var mObserverList: Observer<List<NoteBody>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialisation()
    }

    private fun initialisation() {
        mainAdapter = MainAdapter()
        mRecyclerView = mBinding.notesList
        mRecyclerView.adapter = mainAdapter
        mObserverList = Observer {
            val list = it.asReversed()
            mainAdapter.setList(list)
        }
        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mViewModel.allNotes.observe(this, mObserverList)
        mBinding.addNoteBtn.setOnClickListener{
            APP_ACTIVITY.mNavController.navigate(R.id.action_mainFragment_to_createNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mViewModel.allNotes.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }
}