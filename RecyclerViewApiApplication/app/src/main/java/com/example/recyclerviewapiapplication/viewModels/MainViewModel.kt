package com.example.recyclerviewapiapplication.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerviewapiapplication.repository.ContributorRepository
import com.example.recyclerviewapiapplication.model.ContributorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val contributorRepository: ContributorRepository) : ViewModel() {

    fun getRemoteContributors(){
        viewModelScope.launch(Dispatchers.IO) {
            contributorRepository.getRemoteContributors()
        }
    }


    fun getLocalContributors(): LiveData<List<ContributorModel>> {
        return contributorRepository.getLocalContributors()
    }

    fun insertLocalContributor(contributorModel: List<ContributorModel>) {
        viewModelScope.launch(Dispatchers.IO) {
            contributorRepository.insertLocalContributor(contributorModel)
        }
    }

    fun upsertLocalContributor(contributorModel: List<ContributorModel>){
        viewModelScope.launch(Dispatchers.IO) {
            contributorRepository.upsertLocalContributor(contributorModel)
        }
    }

    fun updateLocalContributor(contributorModel: List<ContributorModel>){
        viewModelScope.launch(Dispatchers.IO) {
                contributorRepository.updateLocalContributors(contributorModel)
        }
    }
    fun deleteLocalContributor(contributorModel:  List<ContributorModel>){
        viewModelScope.launch(Dispatchers.IO) {
            contributorRepository.deleteLocalContributor(contributorModel)
        }
    }

    val contributorsList: LiveData<List<ContributorModel>>
        get() = contributorRepository.contributors

}