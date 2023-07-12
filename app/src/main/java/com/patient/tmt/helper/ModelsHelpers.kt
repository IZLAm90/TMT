package com.patient.tmt.helper

import com.patient.data.model.MedicalSecialtyModel
import com.patient.tmt.R

var mediacal :ArrayList<MedicalSecialtyModel> = arrayListOf()

fun mediacalData():ArrayList<MedicalSecialtyModel>{
    mediacal.add(MedicalSecialtyModel("طب الاسرة و المجتمع", R.drawable.family_ ))
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
