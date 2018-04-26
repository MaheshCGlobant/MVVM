package com.globant.mvvm.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.globant.mvvm.MyApplication
import com.globant.mvvm.R
import com.globant.mvvm.database.MyDatabase
import com.globant.mvvm.di.FragmentModule
import com.globant.mvvm.presenter.RegisterUserPContract
import com.globant.mvvm.viewmodel.RegisterUserViewModel
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.layout_register.*
import javax.inject.Inject


class RegisterUserFragment : AbstractFragment<RegisterUserPContract, RegisterUserViewModel>() {


    companion object {
        val TAG: String = "RegisterUserFragment"
    }

    @Inject
    lateinit var registerUserViewModel: RegisterUserViewModel


    lateinit var registerUserInt: RegisterUserInt


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var app = activity.application

        if (app is MyApplication) {
            app.getAppComponent().plus(FragmentModule(activity)).inject(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.layout_register, null);
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        RxTextView.afterTextChangeEvents(first_name).subscribe(Consumer {
            activity.last_name.isEnabled = it.view().text.isNotEmpty()
        })

        RxTextView.afterTextChangeEvents(last_name).subscribe(Consumer {
            activity.mobile_no.isEnabled = it.view().text.isNotEmpty()
        })

        RxTextView.afterTextChangeEvents(mobile_no).subscribe(Consumer {
            activity.email.isEnabled = it.view().text.isNotEmpty()
        })

        RxTextView.afterTextChangeEvents(email).subscribe(Consumer {
            activity.address.isEnabled = it.view().text.isNotEmpty()
        })

        RxTextView.afterTextChangeEvents(address).subscribe(Consumer {
            activity.save.isEnabled = it.view().text.isNotEmpty()
        })


        activity.save.setOnClickListener(View.OnClickListener {
            registerUserViewModel.saveUserDetails(activity.first_name.text.toString(),
                    activity.last_name.text.toString(),
                    activity.mobile_no.text.toString(),
                    activity.email.text.toString(),
                    activity.address.text.toString(),
                    getRegisterUserObserver())

        })
        
    }

    private fun getRegisterUserObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onComplete() {

                if (activity is RegisterUserInt) {
                    registerUserInt = activity as RegisterUserInt
                    registerUserInt.disposeFragment()
                    Toast.makeText(context, "Record Added", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onError(e: Throwable) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onNext(t: String) {
            }
        }
    }

    public interface RegisterUserInt {
        public fun disposeFragment();
    }

}