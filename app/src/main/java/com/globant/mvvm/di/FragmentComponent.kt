package com.globant.mvvm.di

import com.globant.mvvm.features.RegisterUserFragment
import dagger.Subcomponent


@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
//    fun inject(appCompatActivity: AppCompatActivity)
    fun inject(appCompatActivity: RegisterUserFragment)
}