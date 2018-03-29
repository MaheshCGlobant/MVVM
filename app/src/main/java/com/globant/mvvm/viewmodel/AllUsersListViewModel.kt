package com.globant.mvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.database.Observable
import com.globant.mvvm.database.User
import com.globant.mvvm.presenter.AllUsersPContract
import com.globant.mvvm.repository.UserRepository

/**
 * Created by mahesh.chakkarwar on 05/03/18.
 */

class AllUsersListViewModel(application: Application):AbstractViewModel<AllUsersPContract>(application),AllUsersPContract{
    lateinit var userRepo: UserRepository

    fun setUserRepository(repo: UserRepository){
        userRepo=repo
    }

    override fun getAllUsers(): LiveData<List<User>> {
        return userRepo.loadAllUsers()
    }

    override fun getPresenter(): AllUsersPContract {
        return this;
    }

}