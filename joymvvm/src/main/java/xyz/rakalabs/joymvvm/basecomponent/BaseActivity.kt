package xyz.rakalabs.joymvvm.basecomponent

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.koin.android.architecture.ext.getViewModelByClass
import kotlin.reflect.KClass

abstract class BaseActivity<B: ViewDataBinding, T: BaseViewModel<*>>: AppCompatActivity() {
    /*
    DataBinding & ViewModelComponent
     */
    protected lateinit var binding: B
    protected var vm: T? = null
    /*
    @LayoutID Component for DataBinding
     */
    protected abstract val layoutId: Int
    /*
    @InitViewModel for Support KOIN DSL Dependencies Injection
     */
    protected abstract val initViewModel: KClass<T>

    override fun onDestroy() {
        super.onDestroy()
        if (vm!=null){
            vm!!.dettachView()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        vm = getViewModelByClass(true, initViewModel)
    }
}