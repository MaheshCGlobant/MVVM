package com.globant.mvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

import com.globant.mvvm.presenter.BasePContract


/**
 * Created by mahesh.chakkarwar on 05/01/18.
 */

abstract class AbstractViewModel<P : BasePContract>(application: Application) : AndroidViewModel(application) {
    abstract fun getPresenter(): P
}
