package com.globant.mvvm

/**
 * Created by mahesh.chakkarwar on 21/03/18.
 */

open interface AsyncT<U, T,V>{

    open fun doInBackground(parameters:U)
    open fun onProgressUpdate(progress:T)
    open fun onPostExecute(v:V)
}
