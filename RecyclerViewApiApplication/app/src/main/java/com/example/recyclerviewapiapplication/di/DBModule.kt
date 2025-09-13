package com.example.recyclerviewapiapplication.di

import android.content.Context
import com.example.recyclerviewapiapplication.db.ContributorDatabase
import com.example.recyclerviewapiapplication.db.ContributorDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun provideContributorDatabase(@ApplicationContext context: Context) : ContributorDatabase {
        return ContributorDatabase.getDatabaseInstance(context)
    }

    @Singleton
    @Provides
    fun provideContributorDao(contributorDatabase: ContributorDatabase) : ContributorDao {
        return contributorDatabase.contributorDao()
    }
}