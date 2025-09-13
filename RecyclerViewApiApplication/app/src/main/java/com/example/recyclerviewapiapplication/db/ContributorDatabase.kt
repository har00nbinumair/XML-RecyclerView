package com.example.recyclerviewapiapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recyclerviewapiapplication.model.ContributorModel

@Database(entities = [ContributorModel::class], version = 1)
abstract class ContributorDatabase : RoomDatabase() {
    abstract fun contributorDao(): ContributorDao

    companion object {
        private var databaseInstance: ContributorDatabase? = null

        fun getDatabaseInstance(context: Context): ContributorDatabase {
            if (databaseInstance == null) {
                synchronized(this) {
                    databaseInstance =
                        Room.databaseBuilder(
                            context.applicationContext,
                            ContributorDatabase::class.java,
                            "database"
                        ).build()
                }
            }
            return databaseInstance!!
        }}
}