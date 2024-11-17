package com.rakibcse99.diseaseml.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rakibcse99.diseaseml.databinding.FragmentSyndromeBinding
import com.rakibcse99.diseaseml.repository.model.SyndromeModel
import com.rakibcse99.diseaseml.repository.model.SyndromeRepository
import com.rakibcse99.diseaseml.ui.adpter.SyndromeAdapterNew
import java.util.stream.Collectors.toList
import javax.inject.Inject

class SyndromeFragment : Fragment() {

    private var _binding: FragmentSyndromeBinding? = null
    val syndromeModel = SyndromeRepository()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSyndromeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SyndromeAdapterNew(syndromeModel.syndromeList)


        binding.recylerview.layoutManager = LinearLayoutManager(context)
        binding.recylerview.itemAnimator = DefaultItemAnimator()
        binding.recylerview.setHasFixedSize(true)

        binding.recylerview.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}