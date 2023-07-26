package com.patient.tmt.helper

import androidx.lifecycle.lifecycleScope
import com.patient.data.model.HealthCareModel
import com.patient.data.model.MedicalSecialtyModel
import com.patient.data.model.UserExperienceModel
import com.patient.tmt.R
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

var mediacal: ArrayList<MedicalSecialtyModel> = arrayListOf()
var familyLifeData: ArrayList<HealthCareModel> = arrayListOf()
var selfDevelopmentData: ArrayList<HealthCareModel> = arrayListOf()
var kidsData: ArrayList<HealthCareModel> = arrayListOf()
var nutritionProgrammesData: ArrayList<HealthCareModel> = arrayListOf()
var medicalProgramsData: ArrayList<HealthCareModel> = arrayListOf()
var userExperienceData: ArrayList<UserExperienceModel> = arrayListOf()
var userExperienceDataInPsychological: ArrayList<UserExperienceModel> = arrayListOf()
val list: ArrayList<HealthCareModel> = arrayListOf()
val searchList: ArrayList<String> = arrayListOf()
val searchListCommon: ArrayList<String> = arrayListOf()

fun mediacalData(): ArrayList<MedicalSecialtyModel> {
    mediacal.add(MedicalSecialtyModel("طب الاسرة و المجتمع", R.drawable.family_))
    mediacal.add(MedicalSecialtyModel("نساء وتوليد", R.drawable.femal_s))
    mediacal.add(MedicalSecialtyModel("الأمراض المعدية والأوبئة", R.drawable.infuction_s))
    mediacal.add(MedicalSecialtyModel("طب وعلاج نفسي", R.drawable.psychiatrictreatment_s))
    mediacal.add(MedicalSecialtyModel("أطفال ", R.drawable.kids_s))
    mediacal.add(MedicalSecialtyModel("الجلدية", R.drawable.skin))
    mediacal.add(MedicalSecialtyModel("الأسنان وصحة الفم", R.drawable.tooth_s))
    mediacal.add(MedicalSecialtyModel("التغذية", R.drawable.foods_s))
    mediacal.add(MedicalSecialtyModel("مخ و أعصاب", R.drawable.nerves_s))
    mediacal.add(MedicalSecialtyModel("الغدد الصماء والسكري", R.drawable.endocrine_s))
    mediacal.add(MedicalSecialtyModel("باطنة", R.drawable.stamic_s))
    mediacal.add(MedicalSecialtyModel("الصدرية والنوم", R.drawable.cheest_s))
    mediacal.add(MedicalSecialtyModel("أمراض الدم", R.drawable.blood_s))
    mediacal.add(MedicalSecialtyModel("جهاز هضمي ومناظير", R.drawable.digestive_s))
    mediacal.add(MedicalSecialtyModel("القلب", R.drawable.heart_s))
    mediacal.add(MedicalSecialtyModel("الكلى", R.drawable.colledg))
    mediacal.add(MedicalSecialtyModel("العيون", R.drawable.eyes_s))
    mediacal.add(MedicalSecialtyModel("روماتيزم", R.drawable.rheumatism_s))
    mediacal.add(MedicalSecialtyModel("جراحة التجميل", R.drawable.bueaty_s))
    mediacal.add(MedicalSecialtyModel("جراحات السمنة والمناظير", R.drawable.fats_s))
    mediacal.add(MedicalSecialtyModel("أنف وأذن وحنجرة", R.drawable.nose_ears_s))
    mediacal.add(MedicalSecialtyModel("جراحات القولون", R.drawable.ibs_s))
    mediacal.add(MedicalSecialtyModel("جراحه المسالك البولية", R.drawable.urologist_s))
    mediacal.add(MedicalSecialtyModel("عظام", R.drawable.boans_s))
    mediacal.add(MedicalSecialtyModel("الإقلاع عن التدخين", R.drawable.smoking_s))
    mediacal.add(MedicalSecialtyModel("أطفال الأنابيب والإخصاب المجهري", R.drawable.bomb_kids_s))
    mediacal.add(MedicalSecialtyModel("الأورام", R.drawable.canser_s))
    mediacal.add(MedicalSecialtyModel("تخدير وعلاج الألم", R.drawable.anesthesia_s))
    mediacal.add(MedicalSecialtyModel("جراحة", R.drawable.surgary_s))
    mediacal.add(MedicalSecialtyModel("جراحه مخ و أعصاب", R.drawable.mentality_nervis))
    mediacal.add(MedicalSecialtyModel("تخصصات أخرى", R.drawable.ather_s))
    mediacal.add(MedicalSecialtyModel("الصيدلية", R.drawable.pharmasy_s))
    mediacal.add(MedicalSecialtyModel("طب الطوارئ", R.drawable.surgary_s))
    return mediacal
}

fun getHealthy(): ArrayList<HealthCareModel> {
    list.add(
        HealthCareModel(
            R.drawable.controlofphobia,
            "السيطرة علي الرهاب",
            "حالة من الخوف الشديد والمتواصل من مواقف او نشاطات معينة عند ",
            "عدد الجلسات: 6"
        )
    )
    list.add(
        HealthCareModel(
            R.drawable.anxietyinacrisis,
            "السيطرة علي الرهاب",
            "برنامج علاجي سلوكي معرفي مخصص لكل حاله تتشارك فيه مع",
            "عدد الجلسات: 6"
        )
    )
    list.add(
        HealthCareModel(
            R.drawable.afterdepression,
            "السيطرة علي الرهاب",
            "برنامج علاجي سلوكي معرفي مخمص لكل حاله، تتشارك فيه مع ",
            "عدد الجلسات: 6"
        )
    )
    list.add(
        HealthCareModel(
            R.drawable.obsessivecompulsivedisorder,
            "السيطرة علي الرهاب",
            "أفكار ملازمة ..ملحة وضاغطة يصعب التخلص منها وأفعال قهرية مرهقة",
            "عدد الجلسات: 6"
        )
    )
    list.add(
        HealthCareModel(
            R.drawable.panicdisorder,
            "السيطرة علي الرهاب",
            "شعور مفاجئ يتصاعد في غفون عشر دقائق حالة من الفزع الشديد",
            "عدد الجلسات: 6"
        )
    )
    list.add(
        HealthCareModel(
            R.drawable.pathologicalemotionalattachment,
            "السيطرة علي الرهاب",
            "تمثل القدرة على تكوين علاقات محية مع الآخرين جزءا ضروريا فى",
            "عدد الجلسات: 6"
        )
    )
    list.add(
        HealthCareModel(
            R.drawable.sensitivepersonality,
            "السيطرة علي الرهاب",
            "لكل انسان نمط شخصية مختلف ، الا أن البعض قد يعانى من بعض",
            "عدد الجلسات: 6"
        )
    )
    list.add(
        HealthCareModel(
            R.drawable.anxietyinacrisis,
            "السيطرة علي الرهاب",
            "ينتابك ذعر وأفكار سلبية ؟ قلق ومتوتر بإستمرار ؟ نومك اضطرب ",
            "عدد الجلسات: 6"
        )
    )
    list.add(
        HealthCareModel(
            R.drawable.achievementcourse,
            "السيطرة علي الرهاب",
            "لقلق فترة الامتحانات من الأمور الطبيعية وهو أحد دوافع النجاح. إلا ",
            "عدد الجلسات: 6"
        )
    )
    return list
}

fun familyLifeProgrammesData(): ArrayList<HealthCareModel> {
    familyLifeData.add(
        HealthCareModel(
            R.drawable.better_life,
            "لحياة سعيدة آمنة",
            "لا تخلو الحياة الاجتماعية و الزوجية من خلافات لكن بعضها قد يكون من",
            "عدد الجلسات: 4"
        )
    )
    familyLifeData.add(
        HealthCareModel(
            R.drawable.family_nerveus,
            "الانفصال العاطفي بين الزوجين",
            "إن فقدان الأزواج لأسلوب الحوار الهادف، وظهور مستوى مرتفع من",
            "عدد الجلسات: 4"
        )
    )
    return familyLifeData
}

fun selfDevelopmentData(): ArrayList<HealthCareModel> {
    selfDevelopmentData.add(
        HealthCareModel(
            R.drawable.better_life,
            "إدارة الغضب ",
            "برنامج علاجي سلوكي معرفي محدد تتم عبر ثلاث جلسات لاكسابك عدة ",
            "عدد الجلسات:"
        )
    )
    selfDevelopmentData.add(
        HealthCareModel(
            R.drawable.family_nerveus,
            "مهارات توكيد الذات",
            " مشاعر متضاربة بين التعبير عن الشعور وقول لا أو ابداء الرأي وبين", "عدد الجلسات: "
        )
    )
    selfDevelopmentData.add(
        HealthCareModel(
            R.drawable.family_nerveus,
            "إستعادة الثقة بالنفس",
            " إن تقييم المرء الكلي لذاته إما بطريقة إيجابية أو بطريقة سلبية. مدى إيمان",
            "عدد الجلسات:6  "
        )
    )
    selfDevelopmentData.add(
        HealthCareModel(
            R.drawable.family_nerveus,
            "ادارة المشاعر الايجابية",
            "لاحظ أن علاقاتك متوترة. ومشاعرك مفطرية ومتناقضة. وتخشى", "عدد الجلسات: 6  "
        )
    )
 selfDevelopmentData.add(
        HealthCareModel(
            R.drawable.family_nerveus,
            "الإقلاع عن التدخين ",
            " برنامج علاجي يجمع بين العلاج الدوائي والإرشاد النفسى ", "عدد الجلسات: 8  "
        )
    )
    selfDevelopmentData.add(
        HealthCareModel(
            R.drawable.family_nerveus,
            "برنامج رجال الأعمال",
            " واجه أصحاب المهام المزدحمة العديد من التحديات على مستوى  ", "عدد الجلسات: 15  "
        )
    )
    selfDevelopmentData.add(
        HealthCareModel(
            R.drawable.family_nerveus,
            "باقة المرأة المعاصرة ",
            "تعتبر المرأة المعاصرة عنصر مؤثر في المجتمعات وبناء ونطور المدنية  ", "عدد الجلسات: 12  "
        )
    )
    return selfDevelopmentData
}

fun kidsData():ArrayList<HealthCareModel>{
    kidsData.add(HealthCareModel( R.drawable.family_nerveus,"برنامج تعديل سلوك الطفل","متى أبدأ بتعليم طفلي الحمام ؟ طفلى عنيد ! لا أتمكن من السيطرة","عدد الجلسات: 4"))
    kidsData.add(HealthCareModel( R.drawable.family_nerveus,"بناء شخصية الطفل","لا نشك جميعا ان مشروع بناء شخصية الطفل من المشاريع المهمة","عدد الجلسات:5 "))
    kidsData.add(HealthCareModel( R.drawable.family_nerveus,"القلق النفسي عند الأطفال","جميع الأطفال والمراهقين يمرون بحالات من القلق. وهو أمر طبيعي","عدد الجلسات: 5"))
    kidsData.add(HealthCareModel( R.drawable.family_nerveus,"الإرشاد الوالدي فى التعامل مع المراهقين","جميع الأطفال والمراهقين يمرون بحالات من القلق. وهو أمر طبيعي","عدد الجلسات: 4"))
    kidsData.add(HealthCareModel( R.drawable.family_nerveus,"سنة أولى أمومة في رعاية الرضيع","تسعى كل أم أو امرأة حامل إلى معرفة كل المعلومات اللازمة","عدد الجلسات: 5"))

    return kidsData
}

fun nutritionProgrammesData():ArrayList<HealthCareModel>{
    nutritionProgrammesData.add(HealthCareModel( R.drawable.family_nerveus,"برنامج التحكم السريع في الوزن ","إجراء تغييرات فعلية ملموسة على قياسات الجسم بفترة قصيرة واعتماد","عدد الجلسات: 6"))
    nutritionProgrammesData.add(HealthCareModel( R.drawable.family_nerveus," حمية الكيتو ","معاناة مع زيادة الوزن، جميع الانظمه الغذائية لم تجدي نفعا ","عدد الجلسات: 5"))

    return nutritionProgrammesData
}

fun MedicalProgramsData():ArrayList<HealthCareModel>{
    medicalProgramsData.add(HealthCareModel( R.drawable.family_nerveus,"حمل آمن","حامل بالاشهر الأولى نتمنى (لك السلامه) لكنك بفترة الوحم","عدد الجلسات: 5"))
    medicalProgramsData.add(HealthCareModel( R.drawable.family_nerveus,"برنامج متابعة الحمل"," برنامج متابعة الحمل برنامج مكون من جلسات مقسمة على مدى","عدد الجلسات: 6"))
    medicalProgramsData.add(HealthCareModel( R.drawable.family_nerveus,"باقة متابعة الامراض المزمنة","يعاني الكثير من الأمراض المزمنة سواء من كبار السن او حتى متوسط","عدد الجلسات: 5"))

    return medicalProgramsData
}

fun userExperienceDate():ArrayList<UserExperienceModel>{
    userExperienceData.add(UserExperienceModel("islam","ada","adds","adsda","adsada"))
    userExperienceData.add(UserExperienceModel("islam","ada","adds","adsda","adsada"))
    userExperienceData.add(UserExperienceModel("islam","ada","adds","adsda","adsada"))
    userExperienceData.add(UserExperienceModel("islam","ada","adds","adsda","adsada"))

    return userExperienceData
}

fun getUserExperiance() : ArrayList<UserExperienceModel>{

    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
    userExperienceDataInPsychological.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))

return userExperienceDataInPsychological
}

fun searchDataIssue():ArrayList<String>{
    searchList.add("حراره")
    searchList.add("عدم انتظام الدورة الشهرية")
    searchList.add("حكة")
    searchList.add("حساسية الحليب")
    searchList.add("اضطراب التغذية")
    searchList.add("عقم")
    searchList.add("الامساك")
    searchList.add("التعرق الشديد")
    searchList.add("متلازمة الايض")
    searchList.add("احتباس البول")
    searchList.add("طفح")
    searchList.add("القيئ")
    searchList.add("عسر الحيض")
    searchList.add("نحافة")
    return searchList
}

fun searchDataCommon():ArrayList<String>{
    searchListCommon.add("هشاشه العظام")
    searchListCommon.add("شلل الوجة النصفي")
    searchListCommon.add("البهاق")
    searchListCommon.add("التهاب الجيوب")
    searchListCommon.add("الصدفية")
    searchListCommon.add("عقم")
    searchListCommon.add("الامساك")
    searchListCommon.add("التعرق الشديد")
    searchListCommon.add("متلازمة الايض")
    searchListCommon.add("احتباس البول")
    searchListCommon.add("طفح")
    searchListCommon.add("التهاب الاحليل")
    searchListCommon.add("حب الشباب ")
    return searchListCommon
}
