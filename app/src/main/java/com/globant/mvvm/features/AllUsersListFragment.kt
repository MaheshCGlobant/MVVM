package com.globant.mvvm.features

import android.arch.lifecycle.Observer
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globant.mvvm.MyApplication
import com.globant.mvvm.R
import com.globant.mvvm.database.User
import com.globant.mvvm.di.FragmentModule
import com.globant.mvvm.features.adapter.UsersListAdapter

import com.globant.mvvm.presenter.AllUsersPContract
import com.globant.mvvm.viewmodel.AllUsersListViewModel
import javax.inject.Inject

/**
 * Created by mahesh.chakkarwar on 05/03/18.
 */

class AllUsersListFragment : AbstractFragment<AllUsersPContract, AllUsersListViewModel>() {
    companion object {
        val TAG:String="AllUsersListFragment"
    }

    @Inject
    lateinit var allUsersListViewModel: AllUsersListViewModel

    val linearLayoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false);

    lateinit var observer: Observer<List<User>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var app = activity.application

        if (app is MyApplication) {
            app.getAppComponent().plus(FragmentModule(activity)).inject(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.layout_users_list, null)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerViewUsers=view?.findViewById<RecyclerView>(R.id.recyclerViewUsers)
//        recyclerViewUsers?.layoutManager=linearLayoutManager
        var list=ArrayList<User>()
        recyclerViewUsers?.adapter=UsersListAdapter(context,list);
        observer=Observer{
            it?.forEach {
                list.add(it)
            }
            recyclerViewUsers?.adapter?.notifyDataSetChanged()
        }
        allUsersListViewModel.getAllUsers().observe(activity,observer)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        allUsersListViewModel.getAllUsers().removeObserver(observer)
    }

}
