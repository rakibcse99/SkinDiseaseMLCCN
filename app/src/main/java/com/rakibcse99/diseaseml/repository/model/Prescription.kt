package com.rakibcse99.diseaseml.repository.model

data class Prescription(
    val patientName: String,
    val age: Int,
    val diagnosis: String,
    val medications: List<Medication>,
    val advice: String
)



data class Medication(
    val name: String,
    val dose: String,
    val frequency: String,
    val duration: String
)