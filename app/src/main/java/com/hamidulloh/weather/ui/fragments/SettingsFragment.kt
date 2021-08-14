package com.hamidulloh.weather.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hamidulloh.weather.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.backLl.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.rateLl.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Coming soon", Toast.LENGTH_LONG
            ).show()
        }
        binding.aboutLl.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Coming soon", Toast.LENGTH_LONG
            ).show()
        }
        binding.theTeamTxt.setOnClickListener {
            Toast.makeText(
                requireContext(), "Coming soon", Toast.LENGTH_LONG
            ).show()
        }
        binding.darkModeLl.setOnClickListener {
            Toast.makeText(
                requireContext(), "Coming soon", Toast.LENGTH_LONG
            ).show()
        }

        binding.reportIssueLl.setOnClickListener {
            val reportIssue = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://t.me/usmonga_murojaat_bot")
            )
            startActivity(reportIssue)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}