package com.patient.di

import com.patient.data.repository.DataRepo
import com.patient.data.repository.data.DataRepoImp
import com.patient.data.repository.medicalrepo.MedicalRepoImp
import com.patient.data.repository.medicalrepo.MedicalSpecialtyRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthRepositoryModule {
    @Binds
    abstract fun providesAuthRepo(repo: DataRepoImp): DataRepo
}
@Module
@InstallIn(SingletonComponent::class)
abstract class MedicalRepositoryModule {
    @Binds
    abstract fun providesMedicalRepo(repo: MedicalRepoImp): MedicalSpecialtyRepo
}
