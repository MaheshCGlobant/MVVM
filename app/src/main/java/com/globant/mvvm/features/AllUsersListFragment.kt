package com.globant.mvvm.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globant.mvvm.R

import com.globant.mvvm.presenter.AllUsersPContract
import com.globant.mvvm.viewmodel.AllUsersListViewModel

/**
 * Created by mahesh.chakkarwar on 05/03/18.
 */

class AllUsersListFragment : AbstractFragment<AllUsersPContract, AllUsersListViewModel>() {
    companion object {
        val TAG:String="AllUsersListFragment"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.layout_users_list, null);
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
