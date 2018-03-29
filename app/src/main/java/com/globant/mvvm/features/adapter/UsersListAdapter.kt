package com.globant.mvvm.features.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.globant.mvvm.R
import com.globant.mvvm.database.User

/**
 * Created by mahesh.chakkarwar on 06/03/18.
 */

class UsersListAdapter(val context: Context, usersList: List<User>) : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {

    val inflater: LayoutInflater = LayoutInflater.from(context)
    val users = usersList;

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_users_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.textViewName?.setText(users.get(position).firstName + " " + users.get(position).lastName)
        holder?.textViewMobileNo?.setText(users.get(position).mobileNo)
        holder?.textViewEmail?.setText(users.get(position).email)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView? = view?.findViewById<TextView>(R.id.textViewName)
        val textViewMobileNo: TextView? = view?.findViewById<TextView>(R.id.textViewMobileNo)
        val textViewEmail: TextView? = view?.findViewById<TextView>(R.id.textViewEmail)
    }
}
