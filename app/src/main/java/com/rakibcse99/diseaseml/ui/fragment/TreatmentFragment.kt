package com.rakibcse99.diseaseml.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.rakibcse99.diseaseml.databinding.FragmentTreatmentBinding
import com.rakibcse99.diseaseml.repository.model.SyndromeRepository
import com.rakibcse99.diseaseml.repository.model.TreatmentRepository


class TreatmentFragment : Fragment() {

    private var _binding: FragmentTreatmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentTreatmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}