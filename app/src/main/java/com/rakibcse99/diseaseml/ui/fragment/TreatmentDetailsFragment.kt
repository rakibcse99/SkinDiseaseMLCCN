package com.rakibcse99.diseaseml.ui.fragment

import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rakibcse99.diseaseml.R
import com.rakibcse99.diseaseml.databinding.FragmentTreatmentDetailsBinding
import com.rakibcse99.diseaseml.repository.model.Medication
import com.rakibcse99.diseaseml.repository.model.Prescription
import com.rakibcse99.diseaseml.repository.model.TreatmentRepository


class TreatmentDetailsFragment : Fragment() {

    lateinit var binding: FragmentTreatmentDetailsBinding
    private val repository = TreatmentRepository()
    private lateinit var prescription: Prescription
    var postid: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTreatmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = requireArguments()

        postid = bundle.getInt("id")
        prescription = Prescription(
            patientName = "Md Rakibul Hasan     Sex :Male",
            age = 25,
            diagnosis = "Fungal Infection",
            medications = listOf(
                Medication("Antifungal Cream", "Apply thin layer", "Twice a day", "2 weeks"),
                Medication("Oral Fluconazole", "150 mg", "Once a week", "4 weeks")
            ),
            advice = "Maintain hygiene and keep area dry."
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myWewView()
        binding.downloadBtn.setOnClickListener {
        //    generatePdf(prescription)
            generatePdff(requireContext(),prescription)
        }
    }

    private fun myWewView() {

        val myWebView = binding.webView
        var webSettings = myWebView.settings;
        webSettings.setJavaScriptEnabled(true);
        val DESKTOP_USER_AGENT =
            "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2049.0 Safari/537.36"
        myWebView.getSettings().setUserAgentString(DESKTOP_USER_AGENT)

//improve WebView Performance
        webSettings.domStorageEnabled = true
        myWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH)
        myWebView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        myWebView.setWebChromeClient(WebChromeClient())
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setEnableSmoothTransition(true)
        webSettings.setAllowContentAccess(true)
        myWebView.webViewClient = MyWebViewClient()

        val treatment = repository.findTreatmentById(postid)
        if (treatment != null) {

            treatment.treatmentDescription?.let {
                myWebView.loadDataWithBaseURL(
                    null,
                    it,
                    "text/html; application/pdf",
                    "UTF-8",
                    null
                )
            }
        } else {
            println("Syndrome with ID $id not found.")
        }
//Load Website
        // myWebView.loadUrl(mUserUrl);


    }


    private inner class MyWebViewClient : WebViewClient() {

        @Deprecated("Deprecated in Java")
        override fun onReceivedError(
            webView: WebView,
            errorCode: Int,
            description: String?,
            failingUrl: String?,
        ) {
            try {
                webView.stopLoading()
            } catch (ignored: Exception) {
            }
            if (webView.canGoBack()) {
                webView.goBack()
            }
            webView.loadUrl("#")
            val alertDialog: AlertDialog =
                AlertDialog.Builder(this@TreatmentDetailsFragment.requireContext()).create()
            alertDialog.setTitle("Error")
            alertDialog.setMessage("Check your internet connection and try again.")
            alertDialog.setButton(
                DialogInterface.BUTTON_POSITIVE, "Try Again",
                DialogInterface.OnClickListener { dialog, which ->
                    //  this@GalleryFragment.requireActivity().finish()
                    //  startActivity( this@GalleryFragment.requireActivity().getIntent())
                    dialog.dismiss()
                })
            alertDialog.show()
            super.onReceivedError(webView, errorCode, description, failingUrl)
        }
    }


    private fun generatePdff(context: Context, prescription: Prescription) {
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(500, 700, 1).create()
        val page = pdfDocument.startPage(pageInfo)

        val canvas = page.canvas
        val paint = Paint()
        paint.textSize = 14f
        paint.isAntiAlias = true

        // App logo
        val logo = BitmapFactory.decodeResource(context.resources, R.drawable.ic_skin)
        val scaledLogo = Bitmap.createScaledBitmap(logo, 100, 100, false)
        canvas.drawBitmap(scaledLogo, 200f, 20f, paint)

        // App name
        paint.textSize = 30f
        paint.isFakeBoldText = true
        canvas.drawText("Skin Disease - Medical Prescription", 20f, 160f, paint)

        // Prescription title
        paint.textSize = 20f
        canvas.drawText("Prescription", 30f, 190f, paint)

        // Patient Info
        paint.textSize = 16f
        paint.isFakeBoldText = true
        canvas.drawText("Patient Name: ${prescription.patientName}", 30f, 230f, paint)
        paint.textSize = 14f
        canvas.drawText("Age: ${prescription.age}", 30f, 250f, paint)
        paint.textSize = 14f
        canvas.drawText("Diagnosis: ${prescription.diagnosis}", 30f, 270f, paint)

        // Medicine Details
        canvas.drawText("Antifungal Cream: ${prescription.medications[0].name}", 30f, 300f, paint)
        paint.textSize = 14f
        canvas.drawText("Dosage: ${prescription.medications[0].dose}", 30f, 320f, paint)
        paint.textSize = 14f
        canvas.drawText("frequency: ${prescription.medications[0].frequency}", 30f, 340f, paint)
        paint.textSize = 14f
        canvas.drawText("Duration: ${prescription.medications[0].duration}", 30f, 360f, paint)


        paint.textSize = 14f
        canvas.drawText("Antifungal Cream: ${prescription.medications[1].name}", 30f, 400f, paint)
        paint.textSize = 14f
        canvas.drawText("Dosage: ${prescription.medications[1].dose}", 30f, 420f, paint)
        paint.textSize = 14f
        canvas.drawText("frequency: ${prescription.medications[1].frequency}", 30f, 440f, paint)
        paint.textSize = 14f
        canvas.drawText("Duration: ${prescription.medications[1].duration}", 30f, 460f, paint)
        paint.textSize = 18f
        canvas.drawText("Instructions: ${prescription.advice}", 30f, 490f, paint)

        pdfDocument.finishPage(page)

        // Save to Documents directory
        savePdfToDocuments( pdfDocument, prescription)

        pdfDocument.close()
        logo.recycle()
    }

    private fun savePdfToDocuments(pdfDocument: PdfDocument, prescription: Prescription) {
        val resolver = requireContext().contentResolver
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, "Prescription_${prescription.patientName}.pdf")
            put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + "/Prescriptions")
        }

        val uri = resolver.insert(MediaStore.Files.getContentUri("external"), contentValues)

        if (uri != null) {
            resolver.openOutputStream(uri).use { outputStream ->
                if (outputStream != null) {
                    try {
                        pdfDocument.writeTo(outputStream)
                        showToast("PDF saved successfully!")

                        // Force a rescan to make the file visible
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                            val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
                            intent.data = uri
                            requireContext().sendBroadcast(intent)
                        }

                        // Optionally, open the file to verify
                        val openIntent = Intent(Intent.ACTION_VIEW).apply {
                            setDataAndType(uri, "application/pdf")
                            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        }
                        startActivity(openIntent)

                    } catch (e: Exception) {
                        e.printStackTrace()
                        showToast("Failed to save PDF: ${e.message}")
                    }
                } else {
                    showToast("Failed to open output stream.")
                }
            }
        } else {
            showToast("Failed to create URI for saving PDF.")
        }

        pdfDocument.close()
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


//
//
//    fun generatePdf(prescription: Prescription) {
//        val document = PdfDocument()
//        val pageInfo = PdfDocument.PageInfo.Builder(300, 600, 1).create()
//        val page = document.startPage(pageInfo)
//        val canvas = page.canvas
//        val paint = Paint().apply {
//            color = Color.BLACK
//            textSize = 14f
//            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
//        }
//        canvas.drawText("Prescription for ${prescription.patientName}", 10f, 25f, paint)
//        canvas.drawText("Age: ${prescription.age}", 10f, 50f, paint)
//        canvas.drawText("Diagnosis: ${prescription.diagnosis}", 10f, 75f, paint)
//
//        // Add medications
//        var yPosition = 100f
//        prescription.medications.forEach {
//            canvas.drawText("${it.name} - ${it.dose}, ${it.frequency}, for ${it.duration}", 10f, yPosition, paint)
//            yPosition += 25f
//        }
//
//        document.finishPage(page)
//
//        // Saving to external storage
//        val file = File(Environment.getExternalStorageDirectory(), "Prescription_${prescription.patientName}.pdf")
//        document.writeTo(FileOutputStream(file))
//        document.close()
//    }
}




