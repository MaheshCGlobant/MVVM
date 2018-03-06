package com.globant.mvvm.repository

import android.arch.lifecycle.LiveData
import android.support.annotation.MainThread
import android.util.Log

import com.globant.mvvm.database.User
import com.globant.mvvm.database.UserDao
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Callable
import javax.inject.Inject

/**
 * Created by mahesh.chakkarwar on 09/02/18.
 */

class UserRepository @Inject constructor(userDao: UserDao){
    var userDao:UserDao=userDao

    fun saveDetails(user: User):Observable<String> {

        return Observable.fromCallable(object :Callable<String>{
            override fun call(): String {
                Log.v("UserRepository", "User saved successfully"+user.toString())
                userDao.save(user)
                return "Success"
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }


    fun loadAllUsers(): LiveData<List<User>> {
        return userDao.loadAllUsers()
    }


}
