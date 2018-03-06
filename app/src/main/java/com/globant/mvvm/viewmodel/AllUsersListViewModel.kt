package com.globant.mvvm.viewmodel

import android.app.Application
import android.database.Observable
import com.globant.mvvm.database.User
import com.globant.mvvm.presenter.AllUsersPContract

/**
 * Created by mahesh.chakkarwar on 05/03/18.
 */

class AllUsersListViewModel(application: Application):AbstractViewModel<AllUsersPContract>(application),AllUsersPContract{
    override fun getAllUsers(): Observable<List<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPresenter(): AllUsersPContract {
        return this;
    }

}