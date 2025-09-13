package com.example.recyclerviewapiapplication.retrofit

import com.example.recyclerviewapiapplication.model.ContributorModel
import retrofit2.Response
import retrofit2.http.GET

interface ContributorApiService {
    @GET(value = "contributors")
    suspend fun getLocalContributors() : Response<ArrayList<ContributorModel>>
}