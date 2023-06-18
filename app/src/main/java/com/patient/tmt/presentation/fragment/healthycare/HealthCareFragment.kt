package com.patient.tmt.presentation.fragment.healthycare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.patient.base.BaseFragment
import com.patient.data.model.HealthCareModel
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentHealthCareBinding
import com.patient.tmt.presentation.adapter.PsychologicalProgrammesAdapter

class HealthCareFragment : BaseFragment(R.layout.fragment_health_care) {
    private val viewModel by viewModels<HealthyCareViewModel>()
    private val adapterPsychological=PsychologicalProgrammesAdapter()
    private lateinit var binding : FragmentHealthCareBinding
    val list : ArrayList<HealthCareModel> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHealthCareBinding.bind(view)
        setUpRvs()

    }
    fun setUpRvs(){
        getHealthy()
        binding.apply {
            rvPsychologicalProgrammes.adapter=adapterPsychological
            adapterPsychological.AddAll(list)
        }
    }
    fun getHealthy(){
        list.add(HealthCareModel(R.drawable.controlofphobia,"السيطرة علي الرهاب"
            ,"حالة من الخوف الشديد والمتواصل من مواقف او نشاطات معينة عند ",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.anxietyinacrisis,"السيطرة علي الرهاب"
            ,"برنامج علاجي سلوكي معرفي مخصص لكل حاله تتشارك فيه مع",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.afterdepression,"السيطرة علي الرهاب"
            ,"برنامج علاجي سلوكي معرفي مخمص لكل حاله، تتشارك فيه مع ",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.obsessivecompulsivedisorder,"السيطرة علي الرهاب"
            ,"أفكار ملازمة ..ملحة وضاغطة يصعب التخلص منها وأفعال قهرية مرهقة",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.panicdisorder,"السيطرة علي الرهاب"
            ,"شعور مفاجئ يتصاعد في غفون عشر دقائق حالة من الفزع الشديد",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.pathologicalemotionalattachment,"السيطرة علي الرهاب"
            ,"تمثل القدرة على تكوين علاقات محية مع الآخرين جزءا ضروريا فى",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.sensitivepersonality,"السيطرة علي الرهاب"
            ,"لكل انسان نمط شخصية مختلف ، الا أن البعض قد يعانى من بعض" ,
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.anxietyinacrisis,"السيطرة علي الرهاب"
            ,"ينتابك ذعر وأفكار سلبية ؟ قلق ومتوتر بإستمرار ؟ نومك اضطرب ",
            "عدد الجلسات: 6"))
        list.add(HealthCareModel(R.drawable.achievementcourse,"السيطرة علي الرهاب"
            ,"لقلق فترة الامتحانات من الأمور الطبيعية وهو أحد دوافع النجاح. إلا ",
            "عدد الجلسات: 6"))
        viewModel.getPsychologicalProgrammes(list)
    }
}