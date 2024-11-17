package com.rakibcse99.diseaseml.repository.model

data class TreatmentModel(var id: Int, var treatmentTitle: String, var treatmentDescription: String)


class TreatmentRepository {
    private val treatmentList = ArrayList<TreatmentModel>()

    init {

        treatmentList.add(
            TreatmentModel(
                1,
                "Eczema",
                "<html><h2>Diagnosis</h2>\n" +
                        "<p>To diagnose atopic dermatitis, your health care provider will likely talk with you about your symptoms, examine your skin and review your medical history. You may need tests to identify allergies and rule out other skin diseases.</p>\n" +
                        "<p>If you think a certain food caused your child's rash, ask your health care provider about potential food allergies.</p>\n" +
                        "<div data-nosnippet=\"true\">&nbsp;</div>\n" +
                        "<h3>Patch testing</h3>\n" +
                        "<p>Your doctor may recommend patch testing on your skin. In this test, small amounts of different substances are applied to your skin and then covered. During visits over the next few days, the doctor looks at your skin for signs of a reaction. Patch testing can help diagnose specific types of allergies causing your dermatitis.</p>\n" +
                        "<h2>Treatment</h2>\n" +
                        "<p>Treatment of atopic dermatitis may start with regular moisturizing and other self-care habits. If these don't help, your health care provider might suggest medicated creams that control itching and help repair skin. These are sometimes combined with other treatments.</p>\n" +
                        "<p>Atopic dermatitis can be persistent. You may need to try various treatments over months or years to control it. And even if treatment is successful, symptoms may return (flare).</p>\n" +
                        "<h3>Medications</h3>\n" +
                        "<ul>\n" +
                        "<li>\n" +
                        "<p><strong>Medicated products applied to the skin.</strong>&nbsp;Many options are available to help control itching and repair the skin. Products are available in various strengths and as creams, gels and ointments. Talk with your health care provider about the options and your preferences. Whatever you use, apply it as directed (often twice a day), before you moisturize. Overuse of a corticosteroid product applied to the skin may cause side effects, such as thinning skin.</p>\n" +
                        "<p>Creams or ointments with a calcineurin inhibitor might be a good option for those over age 2. Examples include tacrolimus (Protopic) and pimecrolimus (Elidel). Apply it as directed, before you moisturize. Avoid strong sunlight when using these products.</p>\n" +
                        "<p>The Food and Drug Administration requires that these products have a black box warning about the risk of lymphoma. This warning is based on rare cases of lymphoma among people using topical calcineurin inhibitors. After 10 years of study, no causal relationship between these products and lymphoma and no increased risk of cancer have been found.</p>\n" +
                        "</li>\n" +
                        "<li><strong>Drugs to fight infection.</strong>&nbsp;Your health care provider may prescribe antibiotic pills to treat an infection.</li>\n" +
                        "<li><strong>Pills that control inflammation.</strong>&nbsp;For more-severe eczema, your health care provider may prescribe pills to help control your symptoms. Options might include cyclosporine, methotrexate, prednisone, mycophenolate and azathioprine. These pills are effective but can't be used long term because of potential serious side effects.</li>\n" +
                        "<li><strong>Other options for severe eczema.</strong>&nbsp;The injectable biologics (monoclonal antibodies) dupilumab (Dupixent) and tralokinumab (Adbry) might be options for people with moderate to severe disease who don't respond well to other treatment. Studies show that it's safe and effective in easing the symptoms of atopic dermatitis. Dupilumab is for people over age 6. Tralokinumab is for adults.</li>\n" +
                        "</ul>\n" +
                        "<h3>Therapies</h3>\n" +
                        "<ul>\n" +
                        "<li><strong>Wet dressings.</strong>&nbsp;An effective, intensive treatment for severe eczema involves applying a corticosteroid ointment and sealing in the medication with a wrap of wet gauze topped with a layer of dry gauze. Sometimes this is done in a hospital for people with widespread lesions because it's labor intensive and requires nursing expertise. Or ask your health care provider about learning how to use this technique at home safely.</li>\n" +
                        "<li>\n" +
                        "<p><strong>Light therapy.</strong>&nbsp;This treatment is used for people who either don't get better with topical treatments or rapidly flare again after treatment. The simplest form of light therapy (phototherapy) involves exposing the affected area to controlled amounts of natural sunlight. Other forms use artificial ultraviolet A (UVA) and narrow band ultraviolet B (UVB) alone or with drugs.</p>\n" +
                        "<p>Though effective, long-term light therapy has harmful effects, including premature skin aging, changes in skin color (hyperpigmentation) and an increased risk of skin cancer. For these reasons, phototherapy is less commonly used in young children and is not given to infants. Talk with your health care provider about the pros and cons of light therapy.</p>\n" +
                        "</li>\n" +
                        "<li><strong>Counseling.</strong>&nbsp;If you're embarrassed or frustrated by your skin condition, it can help to talk with a therapist or other counselor.</li>\n" +
                        "<li><strong>Relaxation, behavior modification and biofeedback.</strong>&nbsp;These approaches may help people who scratch out of habit.</li>\n" +
                        "</ul>\n" +
                        "<h3>Baby eczema</h3>\n" +
                        "<p>Treatment for eczema in babies (infantile eczema) includes:</p>\n" +
                        "<ul>\n" +
                        "<li>Identifying and avoiding skin irritants</li>\n" +
                        "<li>Avoiding extreme temperatures</li>\n" +
                        "<li>Giving your baby a short bath in warm water and applying a cream or ointment while the skin is still damp</li>\n" +
                        "</ul>\n" +
                        "<p>See your baby's health care provider if these steps don't improve the rash or it looks infected. Your baby might need a prescription medication to control the rash or treat an infection. Your health care provider might also recommend an oral antihistamine to help lessen the itch and cause drowsiness, which may be helpful for nighttime itching and discomfort. The type of antihistamine that causes drowsiness may negatively affect the school performance of some children.</p>\n" +
                        "<p>&nbsp;</p></html>"
            )
        )

        treatmentList.add(TreatmentModel(7,"Ringworm","<html><div>\n" +
                "<div id=\"management-and-treatment\" class=\"scroll-mt-[112px]\" data-identity=\"article-section\">\n" +
                "<div class=\"\" data-identity=\"rich-text\">\n" +
                "<h3 class=\"text-gray-900 font-bold leading-rem30px text-rem25px bp600:text-rem32px bp600:leading-rem38px mt-rem32px mb-rem16px break-words \" data-identity=\"headline\">How is skin fungus treated?</h3>\n" +
                "<p class=\"text-gray-800 my-rem16px text-rem19px leading-rem34px \" data-identity=\"paragraph-element\">Treatment for skin fungus includes:</p>\n" +
                "<ul class=\"my-rem16px mx-0 pl-[1.25rem] list-disc marker:text-brandBlue-500 marker:pl-rem24px \" data-identity=\"unordered-list\">\n" +
                "<li class=\"mb-rem12px pl-rem12px text-gray-800 text-rem19px leading-rem34px\">Antifungal creams, many of which are available over-the-counter.</li>\n" +
                "<li class=\"mb-rem12px pl-rem12px text-gray-800 text-rem19px leading-rem34px\">Stronger prescription medications, which may work faster.</li>\n" +
                "<li class=\"mb-rem12px pl-rem12px text-gray-800 text-rem19px leading-rem34px\">Oral medicines, if the fungal infection is severe.</li>\n" +
                "</ul>\n" +
                "<h3 class=\"text-gray-900 font-bold leading-rem30px text-rem25px bp600:text-rem32px bp600:leading-rem38px mt-rem32px mb-rem16px break-words \" data-identity=\"headline\">Can I treat a fungal rash at home?</h3>\n" +
                "<p class=\"text-gray-800 my-rem16px text-rem19px leading-rem34px \" data-identity=\"paragraph-element\">It&rsquo;s important for your healthcare provider to see the rash, especially if this is the first time the rash has appeared. Your provider can diagnose it and discuss the best course of action to treat it. Treating a fungal rash with an anti-itch cream that contains a steroid may make the infection worse and more difficult to treat.</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div>\n" +
                "<div id=\"prevention\" class=\"scroll-mt-[112px]\" data-identity=\"article-section\">\n" +
                "<h2 class=\"text-gray-900 font-bold leading-rem34px text-rem32px bp600:text-rem40px bp600:leading-rem44px mt-rem56px mb-rem16px break-words\" data-identity=\"headline\">Prevention</h2>\n" +
                "<div class=\"\" data-identity=\"rich-text\">\n" +
                "<h3 class=\"text-gray-900 font-bold leading-rem30px text-rem25px bp600:text-rem32px bp600:leading-rem38px mt-rem32px mb-rem16px break-words \" data-identity=\"headline\">How can I prevent a fungal rash?</h3>\n" +
                "<p class=\"text-gray-800 my-rem16px text-rem19px leading-rem34px \" data-identity=\"paragraph-element\">In some people, fungal rashes tend to come back (recur) even after treatment. Recurring infections may be due to genetics &mdash; you may be more prone to developing these infections. These steps can help prevent a rash from recurring or developing in the first place:</p>\n" +
                "<p class=\"text-gray-800 my-rem16px text-rem19px leading-rem34px \" data-identity=\"paragraph-element\"><strong>Good foot hygiene</strong></p>\n" +
                "<ul class=\"my-rem16px mx-0 pl-[1.25rem] list-disc marker:text-brandBlue-500 marker:pl-rem24px \" data-identity=\"unordered-list\">\n" +
                "<li class=\"mb-rem12px pl-rem12px text-gray-800 text-rem19px leading-rem34px\">Change your socks and wash your feet regularly. Avoid shoes made of plastic, which doesn&rsquo;t breathe.</li>\n" +
                "<li class=\"mb-rem12px pl-rem12px text-gray-800 text-rem19px leading-rem34px\">Don&rsquo;t walk barefoot, especially in places that may be wet, such as gym showers and locker rooms.</li>\n" +
                "<li class=\"mb-rem12px pl-rem12px text-gray-800 text-rem19px leading-rem34px\">When cutting your toenails, cut straight across the nail. If you have an ingrown toenail, you may need to see a podiatrist to care for it. And if you have a fungal&nbsp;<a class=\"text-brandBlue-500 underline underline-offset-[5px] decoration-1 break-words hover:text-blue-800 transition\" href=\"https://my.clevelandclinic.org/health/diseases/15327-nail-infection-paronychia\" target=\"_blank\" data-identity=\"link\">nail infection</a>, don&rsquo;t use the same nail clippers on healthy nails and infected nails.</li>\n" +
                "</ul>\n" +
                "<p class=\"text-gray-800 my-rem16px text-rem19px leading-rem34px \" data-identity=\"paragraph-element\"><strong>Proper medicine use</strong></p>\n" +
                "<ul class=\"my-rem16px mx-0 pl-[1.25rem] list-disc marker:text-brandBlue-500 marker:pl-rem24px \" data-identity=\"unordered-list\">\n" +
                "<li class=\"mb-rem12px pl-rem12px text-gray-800 text-rem19px leading-rem34px\">If your healthcare provider prescribed a cream (or advised you to use an over-the-counter cream), use the medicine as long as directed. Even after you can no longer see the rash, the fungal infection may still be there, so keep applying the cream as long as your provider recommends.</li>\n" +
                "<li class=\"mb-rem12px pl-rem12px text-gray-800 text-rem19px leading-rem34px\">Your healthcare provider may recommend the same course of treatment for all the members of your family. Often, people living together can pass an infection back and forth. Treating everyone will help make sure the infection is truly gone.</li>\n" +
                "<li class=\"mb-rem12px pl-rem12px text-gray-800 text-rem19px leading-rem34px\">Talk to your healthcare provider about whether you should use an antifungal cream regularly on your feet and nails to help prevent infections.</li>\n" +
                "<li class=\"mb-rem12px pl-rem12px text-gray-800 text-rem19px leading-rem34px\">Using antifungal powder in your shoes every day may help prevent athlete&rsquo;s foot.</li>\n" +
                "</ul>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div></html>" +
                ""))
    }


    fun findTreatmentById(id: Int): TreatmentModel? {
        return treatmentList.find { it.id == id }
    }

}
