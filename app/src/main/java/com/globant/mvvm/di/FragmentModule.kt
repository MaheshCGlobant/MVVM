package com.globant.mvvm.di

import android.support.v4.app.FragmentActivity
import com.globant.mvvm.database.UserDao
import com.globant.mvvm.repository.UserRepository
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import android.arch.lifecycle.ViewModelProviders
import com.globant.mvvm.viewmodel.RegisterUserViewModel


@Module
class FragmentModule(val activity: FragmentActivity) {

    @Provides
    fun providesContext() = activity;

    @Provides
    fun provideRegisterUserViewModel(userRepository: UserRepository): RegisterUserViewModel {
        var registerUserViewModel:RegisterUserViewModel=ViewModelProviders.of(activity).get(RegisterUserViewModel::class.java);
        registerUserViewModel.setUserRepository(userRepository);

        return registerUserViewModel ;
    }

    @NotNull
    @Provides
    fun provideUserRepo(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }
}