package com.globant.mvvm

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.globant.mvvm.features.AllUsersListFragment
import com.globant.mvvm.features.RegisterUserFragment

class MainActivity : AppCompatActivity(), RegisterUserFragment.RegisterUserInt {

    lateinit var registerUserFragment: RegisterUserFragment;
    lateinit var allUsersListFragment: AllUsersListFragment

    lateinit var selectedFragment: String

    override fun disposeFragment() {
        hideUserRegistrationFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerUserFragment = RegisterUserFragment()
        allUsersListFragment = AllUsersListFragment()
        setContentView(R.layout.activity_main)
        showAllUsersList()
        showUserRegistrationFragment();
    }

    private fun showUserRegistrationFragment() {
        var fm: FragmentManager = supportFragmentManager
        var ft = fm.beginTransaction()
        ft.replace(R.id.frameLayout, registerUserFragment).addToBackStack(RegisterUserFragment.TAG)
        ft.commit()
        selectedFragment = RegisterUserFragment.TAG;
    }

    private fun hideUserRegistrationFragment() {
        var fm: FragmentManager = supportFragmentManager
        fm.popBackStack()
        selectedFragment = AllUsersListFragment.TAG
    }

    private fun showAllUsersList() {
        var fm: FragmentManager = supportFragmentManager
        var ft = fm.beginTransaction()
        ft.replace(R.id.frameLayout, allUsersListFragment)
        ft.commit()
        selectedFragment = AllUsersListFragment.TAG;
    }

    override fun onBackPressed() {
        if (selectedFragment.equals(RegisterUserFragment.TAG)) {
            hideUserRegistrationFragment()
        } else {
            super.onBackPressed()
        }
    }
}
