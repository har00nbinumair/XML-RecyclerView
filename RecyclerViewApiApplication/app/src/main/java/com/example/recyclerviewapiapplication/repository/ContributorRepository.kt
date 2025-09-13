package com.example.recyclerviewapiapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recyclerviewapiapplication.db.ContributorDao
import com.example.recyclerviewapiapplication.model.ContributorModel
import com.example.recyclerviewapiapplication.retrofit.ContributorApiService
import javax.inject.Inject

class ContributorRepository @Inject constructor(
    private val contributorApiService: ContributorApiService,
    private val contributorDao: ContributorDao
) {


// <----------- Api Service ----------->
    private val contributorLiveData = MutableLiveData<List<ContributorModel>>()

    val contributors: LiveData<List<ContributorModel>>
        get() = contributorLiveData

    suspend fun getRemoteContributors() {
        val result = contributorApiService.getLocalContributors()
        if (result.body() != null) {
            contributorLiveData.postValue(result.body())
        }
    }

// <------------ Room DataBase ------------>

    suspend fun insertLocalContributor(contributorModel: List<ContributorModel>) {
        contributorDao.insertLocalContributor(contributorModel)
    }

    suspend fun upsertLocalContributor(contributorModel: List<ContributorModel>){
        contributorDao.upsertLocalContributor(contributorModel)
    }

    suspend fun deleteLocalContributor(contributorModel:  List<ContributorModel>) {
        contributorDao.deleteLocalContributor(contributorModel)
    }

    fun getLocalContributors(): LiveData<List<ContributorModel>> {
        return contributorDao.getLocalContributors()
    }

    suspend fun updateLocalContributors(contributorModel: List<ContributorModel> ) {
        contributorDao.updateLocalContributor(contributorModel)
    }
}