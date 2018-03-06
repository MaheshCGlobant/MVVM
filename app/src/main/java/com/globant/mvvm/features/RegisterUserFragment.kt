package com.globant.mvvm.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.globant.mvvm.MainActivity
import com.globant.mvvm.MyApplication
import com.globant.mvvm.R
import com.globant.mvvm.di.FragmentModule
import com.globant.mvvm.presenter.RegisterUserPContract
import com.globant.mvvm.viewmodel.RegisterUserViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject


class RegisterUserFragment : AbstractFragment<RegisterUserPContract, RegisterUserViewModel>() {


    companion object {
        val TAG:String="RegisterUserFragment"
    }
    @Inject
    lateinit var registerUserViewModel: RegisterUserViewModel

    lateinit var first_name: TextView;
    lateinit var last_name: TextView;
    lateinit var mobile_no: TextView;
    lateinit var email: TextView;
    lateinit var address: TextView;
    lateinit var save: Button;

    lateinit var registerUserInt:RegisterUserInt


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
        first_name = view.findViewById(R.id.first_name)
        last_name = view.findViewById(R.id.last_name)
        mobile_no = view.findViewById(R.id.mobile_no)
        email = view.findViewById(R.id.email)
        address = view.findViewById(R.id.address)
        save = view.findViewById(R.id.save)


        save.setOnClickListener(View.OnClickListener {
            registerUserViewModel.saveUserDetails(first_name.text.toString(),
                    last_name.text.toString(),
                    mobile_no.text.toString(),
                    email.text.toString(),
                    address.text.toString(),
                    getRegisterUserObserver())

        })
        first_name.setText(registerUserViewModel.getUserName())
    }

    private fun getRegisterUserObserver():Observer<String>{
        return object:Observer<String>{
            override fun onSubscribe(d: Disposable) {
            }
            override fun onComplete() {

               if(activity is RegisterUserInt) {
                   registerUserInt= activity as RegisterUserInt
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

    public interface RegisterUserInt{
        public fun disposeFragment();
    }

}