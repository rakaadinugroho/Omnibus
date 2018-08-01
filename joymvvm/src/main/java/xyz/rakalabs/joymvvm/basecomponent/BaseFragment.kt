package xyz.rakalabs.joymvvm.basecomponent

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.architecture.ext.getViewModelByClass
import kotlin.reflect.KClass

abstract class BaseFragment<B: ViewDataBinding, T: BaseViewModel<*>>: Fragment() {
    protected lateinit var binding: B
    protected var vm: T? = null
    private lateinit var mRootView: View
    /**
     * @return layout resource id
     */
    protected abstract val layoutId: Int
    /*
    @return GetViewModelComponent from DSL Koin
     */
    protected abstract val initViewModel: KClass<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = getViewModelByClass(true, initViewModel)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        mRootView   = binding.root
        return mRootView
    }

    override fun onDestroy() {
        super.onDestroy()
        if (vm != null) vm!!.dettachView()
    }
}