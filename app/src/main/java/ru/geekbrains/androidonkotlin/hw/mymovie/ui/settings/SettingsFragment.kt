package ru.geekbrains.androidonkotlin.hw.mymovie.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.geekbrains.androidonkotlin.hw.mymovie.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private val settingsViewModel: SettingsViewModel by viewModels {
        SettingsViewModelFactory(requireActivity().application)
    }
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root = binding.root
        val textView = binding.textSettings
        settingsViewModel.text.observe(viewLifecycleOwner, { textView.text = it })
        return root
    }

    override fun onPause() {
        super.onPause()
        settingsViewModel.text.removeObservers(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}