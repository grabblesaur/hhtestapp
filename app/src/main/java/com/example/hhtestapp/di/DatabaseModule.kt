package com.example.hhtestapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import com.example.hhtestapp.BuildConfig
import com.example.hhtestapp.data.database.AppDatabase
import com.example.hhtestapp.data.database.dao.DataDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideRoomDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.APPLICATION_ID)
//            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideDataDao(database: AppDatabase): DataDao {
        return database.dataDao()
    }
}