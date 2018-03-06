package com.globant.mvvm.presenter

import io.reactivex.Observer

public interface RegisterUserPContract : BasePContract {
    fun getUserName():String

    fun saveUserDetails(firstName:String, lastName:String, mobileNo:String, email:String, address:String, observer:Observer<String>)
}