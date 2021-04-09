package com.jellious.demo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.jellious.demo.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        binding.ivImage.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.ivImage to "image_large")
            findNavController().navigate(
                // automatically created when we built our nav graph
                R.id.action_mainFragment_to_imageFragment,
                null,
                null,
                extras
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // avoid a potential memory leak
        _binding = null
    }
}