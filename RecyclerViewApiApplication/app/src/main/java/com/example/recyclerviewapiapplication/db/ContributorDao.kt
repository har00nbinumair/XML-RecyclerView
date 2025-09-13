package com.example.recyclerviewapiapplication.db

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.recyclerviewapiapplication.model.ContributorModel


@Dao
interface ContributorDao {
    @Insert
    suspend fun insertLocalContributor(contributorModel: List<ContributorModel>)

    @Update
    suspend fun updateLocalContributor(contributorModel: List<ContributorModel>)

    @Delete
    suspend fun deleteLocalContributor(contributorModel: List<ContributorModel>)

    @Query("SELECT * FROM contributormodel")
    fun getLocalContributors(): LiveData<List<ContributorModel>>

    @Upsert
    suspend fun upsertLocalContributor(contributorModel: List<ContributorModel>) {
        try {
            insertLocalContributor(contributorModel)
        } catch (e: SQLiteConstraintException) {
            updateLocalContributor(contributorModel)
        }
    }
}