package com.patient.tmt.presentation.fragment.healthycare

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.patient.base.BaseFragment
import com.patient.data.model.HealthCareModel
import com.patient.data.model.UserExperienceModel
import com.patient.tmt.R
import com.patient.tmt.databinding.FragmentHealthCareBinding
import com.patient.tmt.presentation.adapter.AdapterUserExperience
import com.patient.tmt.presentation.adapter.PsychologicalProgrammesAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HealthCareFragment : BaseFragment(R.layout.fragment_health_care) {
    private val viewModel by viewModels<HealthyCareViewModel>()
    private val adapterPsychological = PsychologicalProgrammesAdapter()
    private val adapterFamilyLifeProgrammes = PsychologicalProgrammesAdapter()
    private val adapterSelfDevelopmentProgrammes = PsychologicalProgrammesAdapter()
    private val adapterKidsPrograms = PsychologicalProgrammesAdapter()
    private val adapterNutritionProgrammes = PsychologicalProgrammesAdapter()
    private val adapterMedicalPrograms = PsychologicalProgrammesAdapter()
    private val adapterUserExperience = AdapterUserExperience()
    private lateinit var binding: FragmentHealthCareBinding

    val list: ArrayList<HealthCareModel> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHealthCareBinding.bind(view)
        setUpRvs()

    }

    fun setUpRvs() {
        getHealthy()
        getUserExperiance()
        binding.apply {
            rvPsychologicalProgrammes.adapter = adapterPsychological
            rvFamilyLifeProgrammes.adapter = adapterFamilyLifeProgrammes
            rvSelfDevelopmentProgrammes.adapter = adapterSelfDevelopmentProgrammes
            rvKidsPrograms.adapter = adapterKidsPrograms
            rvNutritionProgrammes.adapter = adapterNutritionProgrammes
            rvMedicalPrograms.adapter = adapterMedicalPrograms
            rvMe.adapter=adapterUserExperience
            adapterPsychological.AddAll(list)
            adapterFamilyLifeProgrammes.AddAll(list)
            adapterSelfDevelopmentProgrammes.AddAll(list)
            adapterKidsPrograms.AddAll(list)
            adapterNutritionProgrammes.AddAll(list)
            adapterMedicalPrograms.AddAll(list)

            back.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    fun getHealthy() {
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
        viewModel.getPsychologicalProgrammes(list)
    }

    fun getUserExperiance() {
        val list: ArrayList<UserExperienceModel> = arrayListOf()
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        list.add(UserExperienceModel("ali", "therapest", "55", "islam", "very good00"))
        viewModel.getUserExperiance(list)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.dataFlowUserExperience.collectLatest {
            adapterUserExperience.addAll(it)
            }
        }

    }
}