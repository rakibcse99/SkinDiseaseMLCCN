package com.rakibcse99.diseaseml.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rakibcse99.diseaseml.R
import com.rakibcse99.diseaseml.databinding.FragmentHomeBinding
import com.rakibcse99.diseaseml.repository.model.SyndromeRepository

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val repository = SyndromeRepository()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val syndrome = repository.findSyndromeById(7)
        if (syndrome != null) {
            binding.titleTV.text = syndrome.skinDiseaseTitle+syndrome.name
            binding.discripTV.text = syndrome.syndromeDescription.toString()
        } else {
            println("Syndrome with ID $id not found.")
        }
        binding.treatmentBtn.setOnClickListener {
            val bundle = bundleOf()
            if (syndrome != null) {
                bundle.putInt("id", syndrome.id)
            }
            findNavController().navigate(R.id.treatmentDetailsFragment,bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}