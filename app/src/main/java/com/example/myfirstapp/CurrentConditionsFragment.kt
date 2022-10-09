package com.example.myfirstapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myfirstapp.databinding.FragmentCurrentConditionsBinding

class CurrentConditionsFragment : Fragment(R.layout.fragment_current_conditions) {

    private lateinit var binding: FragmentCurrentConditionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = resources.getString(R.string.app_name)
        binding = FragmentCurrentConditionsBinding.bind(view)
        binding.forecastButton.setOnClickListener {
            findNavController().navigate(R.id.action_currentConditionsFragment_to_forecastFragment)
        }
    }
}