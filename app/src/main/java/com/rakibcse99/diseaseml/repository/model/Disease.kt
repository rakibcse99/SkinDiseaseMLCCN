package com.rakibcse99.diseaseml.repository.model

data class Disease(
    val id: Int,
    val name: String,
    val code: String,
    val description: String
)

class DiseaseRepository {
    private val diseaseList = ArrayList<Disease>()

    init {
        diseaseList.add(Disease(1, "Acne", "acne", "A skin condition characterized by pimples, blackheads, and whiteheads, commonly occurring on the face, back, and shoulders."))
        diseaseList.add(
            Disease(
                2,
                "Pityriasis Rosea",
                "pityriasis_rosea",
                "A self-limiting skin rash that starts as a single large spot and spreads to smaller patches, often forming a 'Christmas tree' pattern."
            )
        )
        diseaseList.add(
            Disease(
                3,
                "Prurigo Nodularis",
                "prurigo_nodularis",
                "A condition involving hard, itchy lumps on the skin caused by repeated scratching or rubbing."))

        diseaseList.add(
            Disease(
                4,
                "Androgenetic Alopecia",
                "alopecia_androgenetica",
                "A common form of hair loss in both men and women, influenced by genetics and hormones."
            )
        )
        diseaseList.add(Disease(5, "Alopecia Areata", "alopecia_areata", "An autoimmune condition causing hair to fall out in small patches, often leading to total baldness."))
        diseaseList.add(
            Disease(
                6,
                "Bullous Dermatosis",
                "bullous_dermatosis",
                "A group of skin disorders characterized by the formation of blisters on the skin and mucous membranes."
            )
        )

        diseaseList.add(Disease(7, "Chloasma", "chloasma", " Brown patches on the skin, commonly caused by hormonal changes and sun exposure."))
        diseaseList.add(Disease(8, "Corn", "corn", " A thickened area of skin caused by friction or pressure, typically on the feet or hands."))
        diseaseList.add(Disease(9, "Dermatofibroma", "dermatofibroma", " A common noncancerous skin growth, often appearing as a firm, raised nodule."))
        diseaseList.add(Disease(10,"Eczema Dermatitis", "eczema_dermatitis", " A chronic inflammatory skin condition characterized by itchy, red, and scaly patches."))
        diseaseList.add(Disease(11,"Erysipelas", "erysipelas", " A bacterial infection of the skin and underlying tissues, causing redness, swelling, and pain."))
        diseaseList.add(Disease(12,"Erythema Multiforme", "erythema_multiforme", " A reaction pattern of the skin and mucous membranes, often triggered by infections or medications."))
        diseaseList.add(Disease(13,"Folliculitis", "folliculitis", " Inflammation of hair follicles caused by bacterial or fungal infections, leading to red, itchy bumps."))
        diseaseList.add(Disease(14,"Furuncle", "furuncle", " A deep bacterial infection of a hair follicle, resulting in a painful, pus-filled lump."))
        diseaseList.add(Disease(15,"Hemangioma", "haemangioma", "  A benign growth of blood vessels, often appearing as a red or purple skin lesion."))
        diseaseList.add(Disease(16,"Herpes Zoster", "herpes", "A viral infection causing a painful rash, often with blisters, typically on one side of the body."))
        diseaseList.add(Disease(17,"Herpes Simplex", "herpes_simplex", "A viral infection causing blisters and sores, often around the mouth or genital area."))
        diseaseList.add(Disease(18,"IgA Vasculitis", "iga_vasculitis", " A condition causing inflammation of the blood vessels."))
        diseaseList.add(Disease(19,"Keloid", "keloid", "  A type of raised scar that grows beyond the boundaries of the original wound."))
        diseaseList.add(Disease(20, "Keratosis Pilaris", "keratosis_follicularism", " A common skin condition that causes small, gooseflesh-like bumps."))
        diseaseList.add(Disease(21, "Lichen Planus", "lichen_planus", " A chronic autoimmune disease that can affect the skin, joints, kidneys, and other organs."))
        diseaseList.add(Disease(22, "Lupus Erythematosus", "lupus_erythematosus", "  An inflammatory condition that affects the skin and mucous membranes."))
        diseaseList.add(Disease(23, "Molluscum Contagiosum", "molluscum_contagiosum", "  A viral infection that causes small, raised, pearly bumps on the skin."))
        diseaseList.add(Disease(24, "Nevus", "nevus", " Commonly known as moles, these are growths on the skin caused by clusters of pigment-producing cells."))
        diseaseList.add(Disease(25, "Paronychia", "paronychia", "An infection of the skin around the nails."))
        diseaseList.add(Disease(26, "Pityriasis Alba", "pityriasis_alba", "A common condition that causes lighter skin patches, often seen in children."))
        diseaseList.add(Disease(27, "Psoriasis", "psoriasis", "A chronic autoimmune disease that causes the rapid growth of skin cells, leading to scaling."))
        diseaseList.add(Disease(28, "Rosacea", "rosacea", "  A skin condition that causes redness and visible blood vessels in the face."))
        diseaseList.add(Disease(29, "Sebaceous Cyst", "sebaceous_cyst", "A noncancerous, closed pocket of tissue filled with fluid or semiliquid material."))
        diseaseList.add(Disease(30, "Sebaceous Nevus", "sebaceousnevus", " A type of birthmark caused by overgrowth of sebaceous (oil-producing) glands."))
        diseaseList.add(Disease(31, "Seborrheic Dermatitis", "seborrheic_dermatitis", "A common skin condition that causes red, flaky, and greasy patches of skin."))
        diseaseList.add(Disease(32, "Seborrheic Keratosis", "seborrheic_keratosis", " Noncancerous growths on the skin that appear brown, black, or light tan. "))
        diseaseList.add(Disease(34, "Skin Tag", "skin_tag", " Small, benign growths of skin that often appear in folds of the skin. "))
        diseaseList.add(Disease(35, "Stasis Dermatitis", "stasis_dermatitis", "Inflammation of the skin caused by poor circulation and fluid buildup. "))
        diseaseList.add(Disease(36, "Syringoma", "syringoma", "Benign tumors of the sweat glands that appear as small, flesh-colored bumps."))
        diseaseList.add(Disease(37, "Tinea Capitis", "tinea_capitis", " A fungal infection of the scalp that causes hair loss and scaly patches. "))
        diseaseList.add(Disease(38, "Tinea Corporis", "tinea_corporis", " A fungal infection of the body that causes red, itchy, ring-shaped patches. "))
        diseaseList.add(Disease(39, "Tinea Cruris", "tinea_cruris", "A fungal infection of the groin area that causes itching and red rashes."))
        diseaseList.add(Disease(40, "Tinea Manuum", "tinea_manuum", "A fungal infection of the hands, causing red, itchy, ring-shaped rashes."))
        diseaseList.add(Disease(41, "Tinea Pedis", "tinea_pedis", "A fungal infection that affects the feet, causing itching, redness, and peeling skin."))
        diseaseList.add(Disease(42, "Tinea Unguium", "tinea_unguium", " A fungal infection that affects the nails, causing them to become thickened, discolored, and brittle."))
        diseaseList.add(Disease(43, "Tinea Versicolor", "tinea_versicolor", "A fungal infection that causes discolored patches of skin, usually on the chest or back."))
        diseaseList.add(Disease(44, "Urticaria", "urticaria", " A skin reaction that causes raised, red, itchy welts or hives."))
        diseaseList.add(Disease(45, "Papular Urticaria", "urticaria_papular", " A type of urticaria that causes small, itchy bumps on the skin."))
        diseaseList.add(Disease(46, "Varicella", "varicella", " A viral infection that causes an itchy rash with red spots and blisters."))
        diseaseList.add(Disease(47, "Verruca Plana", "verruca_plana", "  Flat, smooth warts that commonly appear on the face, hands, and legs."))
        diseaseList.add(Disease(48, "Verruca Vulgaris", "verruca_vulgaris", "  Warts caused by a viral infection, usually found on hands, fingers, and feet."))
        diseaseList.add(Disease(49, "Vitiligo", "vitiligo", " A condition that causes loss of pigmentation in patches of skin."))
    }
    fun findDisease(code: String): Disease? {
        return diseaseList.find { it.code == code }
    }
}

