package xyz.rakalabs.joymvvm.basecomponent

import android.arch.lifecycle.ViewModel

class BaseViewModel<T>: ViewModel() {
    var view: T? = null
    fun attachView(view: T) {
        this.view = view
    }
    fun dettachView() {
        this.view = null
    }
}