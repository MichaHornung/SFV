package com.example.sfv.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sfv.R
import com.example.sfv.databinding.LoginBinding

class Login : Fragment() {

    private lateinit var binding: LoginBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.anmeldenButton.setOnClickListener{
            findNavController().navigate(LoginDirections.actionLoginToMitgliederBereich())
        }
        binding.anmeldenButton.setOnClickListener{
            val  benutzername = binding.benutzername.text.toString()
            val password = binding.passwort.text.toString()

            if (!benutzername.isEmpty() && !password.isEmpty()){
                viewModel.login(benutzername, password)
            }
        }

        viewModel.currentUser.observe(
            viewLifecycleOwner,{
                if (it != null){
                    findNavController().navigate(R.id.login)
                }
            }

        )
    }
}