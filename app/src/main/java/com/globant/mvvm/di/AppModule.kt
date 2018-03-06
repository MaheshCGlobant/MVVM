package com.globant.mvvm.di

import android.app.Application
import android.arch.persistence.room.Room
import com.globant.mvvm.database.MyDatabase
import com.globant.mvvm.database.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: Application) {
    companion object {
        private val DB_NAME = "appDatabase.db"
    }

    @Singleton
    @Provides
    fun getMyApplication(): Application = app

    @Singleton
    @Provides
    fun getMyDatabase(application: Application): MyDatabase{
        val database = Room.databaseBuilder(application, MyDatabase::class.java, DB_NAME).build()
        return database
    }

    @Singleton
    @Provides
    fun getUserDao(myDatabase: MyDatabase): UserDao{
        return myDatabase.userDao()
    }

}