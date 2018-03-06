package com.globant.mvvm.presenter

import android.database.Observable
import com.globant.mvvm.database.User


/**
 * Created by mahesh.chakkarwar on 05/03/18.
 */

interface AllUsersPContract:BasePContract{
    fun getAllUsers():Observable<List<User>>
}