package quizapp.volkova.notesapp.screen.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import quizapp.volkova.notesapp.R
import quizapp.volkova.notesapp.databinding.FragmentMainBinding
import quizapp.volkova.notesapp.utils.APP_ACTIVITY

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: MainFragmentViewModel

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
        mViewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        mBinding.addNoteBtn.setOnClickListener{
            APP_ACTIVITY.mNavController.navigate(R.id.action_mainFragment_to_createNoteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}