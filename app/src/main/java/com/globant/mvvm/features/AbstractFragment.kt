package com.globant.mvvm.features

import android.os.Bundle
import android.support.v4.app.Fragment
import com.globant.mvvm.presenter.BasePContract
import com.globant.mvvm.viewmodel.AbstractViewModel


/**
 * Created by mahesh.chakkarwar on 08/02/18.
 */
abstract class AbstractFragment<P : BasePContract, VM : AbstractViewModel<P>> : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

//    protected abstract fun getViewModel(): Class<VM>
}