package com.globant.mvvm

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.globant.mvvm.features.AllUsersListFragment
import com.globant.mvvm.features.RegisterUserFragment
import com.globant.mvvm.viewmodel.AllUsersListViewModel

class MainActivity : AppCompatActivity(), RegisterUserFragment.RegisterUserInt {

    lateinit var registerUserFragment: RegisterUserFragment
    lateinit var allUsersListFragment: AllUsersListFragment

    lateinit var selectedFragment: String
    lateinit var floatingActionButton: FloatingActionButton

    override fun disposeFragment() {
        hideUserRegistrationFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerUserFragment = RegisterUserFragment()
        allUsersListFragment = AllUsersListFragment()
        setContentView(R.layout.activity_main)

        floatingActionButton= findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener({
            showUserRegistrationFragment();
        })

        showAllUsersList()

    }

    private fun showUserRegistrationFragment() {
        var fm: FragmentManager = supportFragmentManager
        var ft = fm.beginTransaction()
        ft.replace(R.id.frameLayout, registerUserFragment).addToBackStack(RegisterUserFragment.TAG)
        ft.commit()
        selectedFragment = RegisterUserFragment.TAG;
        floatingActionButton.visibility= View.GONE
    }

    private fun hideUserRegistrationFragment() {
        var fm: FragmentManager = supportFragmentManager
        fm.popBackStack()
        selectedFragment = AllUsersListFragment.TAG
        floatingActionButton.visibility= View.VISIBLE
    }

    private fun showAllUsersList() {
        var fm: FragmentManager = supportFragmentManager
        var ft = fm.beginTransaction()
        ft.replace(R.id.frameLayout, allUsersListFragment)
        ft.commit()
        selectedFragment = AllUsersListFragment.TAG
        floatingActionButton.visibility= View.VISIBLE
    }

    override fun onBackPressed() {
        if (selectedFragment.equals(RegisterUserFragment.TAG)) {
            hideUserRegistrationFragment()

        } else {
            super.onBackPressed()
        }
    }
}
