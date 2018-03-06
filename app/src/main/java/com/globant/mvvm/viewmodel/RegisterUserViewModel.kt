package com.globant.mvvm.viewmodel

import android.app.Application
import android.util.Log

import com.globant.mvvm.database.User
import com.globant.mvvm.presenter.RegisterUserPContract
import com.globant.mvvm.repository.UserRepository
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by mahesh.chakkarwar on 08/02/18.
 */

class RegisterUserViewModel(application: Application) : AbstractViewModel<RegisterUserPContract>(application), RegisterUserPContract {

    lateinit var userRepo: UserRepository

    fun setUserRepository(repo:UserRepository){
        userRepo=repo
    }
    override fun saveUserDetails(firstName: String, lastName: String, mobileNo: String, email: String, address: String, observer: Observer<String>) {

        var user = User();
        user.firstName = firstName;
        user.lastName = lastName;
        user.mobileNo = mobileNo;
        user.email = email;
        user.address = address;
        var observable=userRepo.saveDetails(user)
        observable.subscribe(observer)
    }

    override fun getUserName(): String {
        return "mahesh"
    }

    override fun getPresenter(): RegisterUserPContract {
        return this
    }
}