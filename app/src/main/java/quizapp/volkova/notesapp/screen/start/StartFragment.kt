package quizapp.volkova.notesapp.screen.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_start.*
import quizapp.volkova.notesapp.R
import quizapp.volkova.notesapp.databinding.FragmentStartBinding
import quizapp.volkova.notesapp.utils.*

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialisation()
    }

    private fun initialisation() {
        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
        mBinding.roomBtn.setOnClickListener {
            mViewModel.initDataBase(TYPE_ROOM){
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }
        mBinding.fbBtn.setOnClickListener{
            mBinding.inputPass.visibility = View.VISIBLE
            mBinding.inputEmail.visibility = View.VISIBLE
            mBinding.loginBtn.visibility = View.VISIBLE

            mBinding.loginBtn.setOnClickListener{
                val inputEmail = mBinding.inputEmail.text.toString()
                val inputPass = mBinding.inputPass.text.toString()
                if (inputEmail.isNotEmpty() && inputPass.isNotEmpty()){
                    EMAIL = inputEmail
                    PASS = inputPass
                    mViewModel.initDataBase(TYPE_FIREBASE){
                        showToast("SUCCESS")
                        //APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
                    }
                } else {
                    showToast("Enter email and password")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}