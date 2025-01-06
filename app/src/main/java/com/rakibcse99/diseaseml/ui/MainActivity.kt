package com.rakibcse99.diseaseml.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rakibcse99.diseaseml.base.Status
import com.rakibcse99.diseaseml.databinding.ActivityMainBinding
import com.rakibcse99.diseaseml.ui.adpter.CharacterModelViewAdapter
import com.rakibcse99.diseaseml.ui.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
private lateinit var  binding: ActivityMainBinding
    @Inject
   lateinit var characterViewAdapter: CharacterModelViewAdapter


    private val viewModeCharacter by viewModels<CharacterViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(true) // Hide the default title
        binding.shimmerLChatList.startShimmer()
//      }
    }
}