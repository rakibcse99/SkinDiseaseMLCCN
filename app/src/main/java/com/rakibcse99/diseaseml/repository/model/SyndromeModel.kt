package com.rakibcse99.diseaseml.repository.model

class SyndromeModel( val id: Int,
                          val name: String,
                          val skinDiseaseTitle: String,
                          val syndromeDescription: String)

// Create a repository class to handle SyndromeModel-related data operations
class SyndromeRepository {
    var syndromeList=ArrayList<SyndromeModel>()
init {
    syndromeList.add(SyndromeModel(
        id = 1,
        name = "Eczema",
        skinDiseaseTitle = "Atopic Dermatitis",
        syndromeDescription = "Atopic dermatitis (eczema) is a condition that causes dry, itchy and inflamed skin. It's common in young children but can occur at any age. Atopic dermatitis is long lasting (chronic) and tends to flare sometimes. It can be irritating but it's not contagious.\n" +
                "\n" +
                "People with atopic dermatitis are at risk of developing food allergies, hay fever and asthma.\n" +
                "\n" +
                "Moisturizing regularly and following other skin care habits can relieve itching and prevent new outbreaks (flares). Treatment may also include medicated ointments or creams."

    ))

    syndromeList.add(SyndromeModel(
        id = 2,
        name = "Psoriasis",
        skinDiseaseTitle = "Chronic Plaque Psoriasis",
        syndromeDescription = "An autoimmune disease that causes rapid skin cell buildup, forming scales and red patches that are often itchy and painful. Typically found on the scalp, elbows, and knees."
    ))
    syndromeList.add(SyndromeModel(
        id = 3,
        name = "Rosacea",
        skinDiseaseTitle = "Facial Redness",
        syndromeDescription = "A chronic inflammatory condition that primarily affects the face, causing redness, visible blood vessels, and sometimes pimples. Often aggravated by spicy foods, alcohol, and sunlight."
    ))
    syndromeList.add(SyndromeModel(
        id = 4,
        name = "Vitiligo",
        skinDiseaseTitle = "Pigment Loss",
        syndromeDescription = "A condition in which the skin loses melanin, leading to irregular white patches. The exact cause is unknown, but it may be related to autoimmune issues."
    ))
    syndromeList.add(SyndromeModel(
        id = 5,
        name = "Acne",
        skinDiseaseTitle = "Acne Vulgaris",
        syndromeDescription = "A common skin condition where hair follicles become clogged with oil and dead skin cells, causing pimples, blackheads, and cysts. Often affects the face, chest, and back."
    ))
    syndromeList.add(SyndromeModel(
        id = 6,
        name = "Impetigo",
        skinDiseaseTitle = "Bacterial Skin Infection",
        syndromeDescription = "A contagious bacterial skin infection causing red sores, which can burst and develop honey-colored crusts. Commonly affects children and can appear around the mouth and nose."
    ))
    syndromeList.add(SyndromeModel(
        id = 7,
        name = "Ringworm",
        skinDiseaseTitle = "Fungal Skin Infection",
        syndromeDescription = "A fungal infection that causes a ring-shaped, red, itchy rash on the skin. Can appear on various body parts including the scalp, feet (athlete's foot), and groin (jock itch)."
    ))
    syndromeList.add(SyndromeModel(
        id = 8,
        name = "Shingles",
        skinDiseaseTitle = "Herpes Zoster",
        syndromeDescription = "A reactivation of the chickenpox virus, causing a painful rash, often with blisters, usually on one side of the body. Commonly affects older adults or those with weakened immune systems."
    ))
    syndromeList.add(SyndromeModel(
        id = 9,
        name = "Hives",
        skinDiseaseTitle = "Urticaria",
        syndromeDescription = "A skin reaction that causes itchy welts, often triggered by an allergic reaction. Hives can appear anywhere on the body and vary in size."
    ))
    syndromeList.add(SyndromeModel(
        id = 10,
        name = "Melasma",
        skinDiseaseTitle = "Hyperpigmentation",
        syndromeDescription = "A common skin condition that causes brown or gray patches on the face, especially on the cheeks, bridge of the nose, forehead, and upper lip. Often worsened by sun exposure."
    ))

}


    fun findSyndromeById(id: Int): SyndromeModel? {
        return syndromeList.find { it.id == id }
    }
}