package com.patient.tmt.presentation.fragment.healthycare

import com.patient.data.model.HealthCareModel
import com.patient.data.repository.medicalcare.MedicalCareRepo
import com.patient.domain.medicalcare.MedicalCareUseCase
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class HealthyCareViewModelTest {
    lateinit var  useCase: MedicalCareUseCase
    lateinit var  mediaRepo: MedicalCareRepo
    lateinit var viewModel: HealthyCareViewModel

    @Before
    fun setUp() {

        useCase= MedicalCareUseCase(mediaRepo)
        viewModel =HealthyCareViewModel(useCase)
    }

    @After
    fun tearDown() {
    }
    @Test
    fun `test get getPsychologicalProgrammes sucsses`(){
        val list = ArrayList<HealthCareModel>()
        val expectedResult = ArrayList<HealthCareModel>()
        assertEquals(viewModel.getPsychologicalProgrammes(list),expectedResult)

    }
}