package com.rakibcse99.diseaseml.ui.fragment

import android.Manifest
import android.animation.ValueAnimator
import android.companion.CompanionDeviceManager.RESULT_OK
import android.content.ContentResolver
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.OpenableColumns
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rakibcse99.diseaseml.R
import com.rakibcse99.diseaseml.databinding.FragmentHomeBinding
import com.rakibcse99.diseaseml.repository.model.DiseaseRepository
import com.rakibcse99.diseaseml.repository.model.SyndromeRepository
import com.rakibcse99.diseaseml.ui.viewModel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONException
import org.json.JSONObject
import java.io.File


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: CharacterViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val repository = SyndromeRepository()
    private val diseaseRepository = DiseaseRepository()
    private val PICK_IMAGE_REQUEST = 100

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
//        if (syndrome != null) {
//            binding.titleTV.text = syndrome.skinDiseaseTitle + syndrome.name
//            binding.discripTV.text = syndrome.syndromeDescription.toString()
//        } else {
//            println("Syndrome with ID $id not found.")
//        }
        binding.treatmentBtn.setOnClickListener {
            val bundle = bundleOf()
            if (syndrome != null) {
                bundle.putInt("id", syndrome.id)
            }
            findNavController().navigate(R.id.treatmentDetailsFragment, bundle)
        }

        binding.uploadImage.setOnClickListener {
            checkPermissions()

        }


        viewModel.uploadResult.observe(viewLifecycleOwner) { result ->
            try {
                Log.d("UploadResult", "Raw Result String: $result")

                // Extract the JSON part after "Successful:"
                val jsonPart = result.substringAfter("Successful:").trim()
                Log.d("UploadResult", "Extracted JSON Part: $jsonPart")

                // Parse the JSON part
                val jsonObject = JSONObject(jsonPart)
                Log.d("UploadResult", "Parsed JSON object: $jsonObject")

                val resultsObject = jsonObject.getJSONObject("results")
                val resultsMap = mutableMapOf<String, Double>()
                resultsObject.keys().forEach { key ->
                    resultsMap[key] = resultsObject.getDouble(key)
                }

                val maxEntry = getMaxEntry(resultsMap)
                if (maxEntry != null) {
                    val (topDisease, topAccuracy) = maxEntry

                    val disease = diseaseRepository.findDisease(topDisease)

                    if (disease != null) {
                        binding.titleTV.text = disease.name
                        binding.discripTV.text = disease.description
                    } else {
                        binding.titleTV.text = topDisease
                      //  binding.discripTV.text = "Accuracy: $topAccuracy"
                    }

                } else {
                    Toast.makeText(requireContext(), "No results found", Toast.LENGTH_LONG).show()
                }
            } catch (e: JSONException) {
                Log.e("UploadResult", "Error parsing result: ${e.message}", e)
                Toast.makeText(requireContext(), "Error parsing result: ${e.message}", Toast.LENGTH_LONG).show()
            }



        }
    }


    fun getMaxEntry(map: Map<String, Double>): Map.Entry<String, Double>? {
        return map.maxByOrNull { it.value }
    }


    private fun checkPermissions() {
        val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arrayOf(Manifest.permission.READ_MEDIA_IMAGES)
        } else {
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        if (permissions.any {
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    it
                ) != PackageManager.PERMISSION_GRANTED
            }) {
            requestPermissions(permissions, PICK_IMAGE_REQUEST)
        } else {
            openGallery()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                val file = getFileFromUri(uri)
                if (file != null) {
                    val requestFile = RequestBody.create("image/jpeg".toMediaTypeOrNull(), file)
                    val body = MultipartBody.Part.createFormData("image", file.name, requestFile)
                    binding.imageview.setImageURI(uri)

                    viewModel.uploadImage(body)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Failed to get file from URI",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun getFileFromUri(uri: Uri): File? {
        return try {
            val contentResolver = requireContext().contentResolver
            val inputStream = contentResolver.openInputStream(uri)
            val file = File(requireContext().cacheDir, contentResolver.getFileName(uri))
            val outputStream = file.outputStream()

            inputStream?.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }

            file
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun ContentResolver.getFileName(uri: Uri): String {
        var name = "temp_file"
        val cursor = query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val index = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (index >= 0) {
                    name = it.getString(index)
                }
            }
        }
        return name
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setProgressbarValuess(
        score: Int,
        progressLayout: ConstraintLayout,
        tvProgress: TextView
    ) {
        // Ensure `tvProgress` has a valid numeric value
        val currentScore = tvProgress.text.toString().toIntOrNull() ?: 0

        // Animate the progress text
        val anim = ValueAnimator.ofInt(currentScore, score)
        anim.duration = 1000L
        anim.addUpdateListener { valueAnimator ->
            tvProgress.text = valueAnimator.animatedValue.toString()
        }
        anim.start()

        // Animate the progress layout (horizontal bias)
        val transition = ChangeBounds()
        transition.duration = 1000L

        val constraintLayoutParams = progressLayout.layoutParams as ConstraintLayout.LayoutParams
        constraintLayoutParams.horizontalBias = score / 100f

        TransitionManager.beginDelayedTransition(progressLayout, transition)
        progressLayout.layoutParams = constraintLayoutParams
    }
}