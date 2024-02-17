package com.madhavsolanki.conditionalnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.madhavsolanki.conditionalnavigation.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    companion object{
        const val LOGIN_SUCCESSFUL = "LOGIN_SUCCESSFUL"
    }


    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            // Using Safe state handle
            val savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
            savedStateHandle.set(LOGIN_SUCCESSFUL, false)

            UserLoginInfo.user = null

            btnLogin.setOnClickListener {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()

                UserLoginInfo.user = User(username)
                savedStateHandle.set(LOGIN_SUCCESSFUL, true)
                findNavController().popBackStack()
            }
        }
    }
}