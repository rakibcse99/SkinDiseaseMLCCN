package com.rakibcse99.diseaseml.ui.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rakibcse99.diseaseml.databinding.RowSyndromeBinding
import com.rakibcse99.diseaseml.repository.model.SyndromeModel
import com.rakibcse99.diseaseml.utils.SimpleCallback


class SyndromeAdapterNew(var syndromlist: List<SyndromeModel>) :
    RecyclerView.Adapter<SyndromeAdapterNew.UserHolder>() {

    var clickListener: SimpleCallback<SyndromeModel>? = null

    inner class UserHolder(val binding: RowSyndromeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(syndromeModel: SyndromeModel) {
            binding.titleTv.text=syndromeModel.skinDiseaseTitle+" ("+syndromeModel.name+")"
            binding.root.setOnClickListener {
                clickListener?.callback(syndromeModel)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = RowSyndromeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHolder(binding)
    }


    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(syndromlist[position])
    }

    override fun getItemCount(): Int {
        return syndromlist.size
    }

}
