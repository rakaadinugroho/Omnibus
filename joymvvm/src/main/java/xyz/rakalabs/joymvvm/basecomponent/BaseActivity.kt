package xyz.rakalabs.joymvvm.basecomponent

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import org.koin.android.architecture.ext.getViewModel
import org.koin.android.architecture.ext.getViewModelByClass
import org.koin.android.architecture.ext.viewModelByClass
import kotlin.reflect.KClass

abstract class BaseActivity<B: ViewDataBinding, T: BaseViewModel<*>>: AppCompatActivity() {
    protected lateinit var dataBinding: B
    protected var baseViewModel: T? = null
    protected abstract val initViewModel: KClass<T>
    protected fun bindView(layoutId: Int) {
        dataBinding = DataBindingUtil.setContentView(this, layoutId)
        baseViewModel = getViewModelByClass(true, initViewModel)
    }
    override fun onDestroy() {
        super.onDestroy()
        if (baseViewModel!=null){
            baseViewModel!!.dettachView()
        }
    }
}