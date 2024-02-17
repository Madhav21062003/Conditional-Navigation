package com.madhavsolanki.conditionalnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

import com.madhavsolanki.conditionalnavigation.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentBackStackEntry = findNavController().currentBackStackEntry
        val savedStateHandle = currentBackStackEntry!!.savedStateHandle

        savedStateHandle.getLiveData<Boolean>(LoginFragment.LOGIN_SUCCESSFUL)
            .observe(currentBackStackEntry){
                if (!it){
                    Toast.makeText(requireContext(), "Please Login to see your profile",Toast.LENGTH_SHORT).show()
                  findNavController().navigate(R.id.mainFragment)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            if (UserLoginInfo.user == null) {
                Toast.makeText(requireContext(), "Please login first", Toast.LENGTH_SHORT).show()

                findNavController().navigate(R.id.loginFragment)
            } else {
                val username = UserLoginInfo.user!!.username
                Toast.makeText(requireContext(), "Hi, $username", Toast.LENGTH_SHORT).show()

                val text = getString(R.string.welcome, username)
                tvWelcome.text = text
            }

        }
    }
}