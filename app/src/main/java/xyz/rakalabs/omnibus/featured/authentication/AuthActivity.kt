package xyz.rakalabs.omnibus.featured.authentication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import xyz.rakalabs.joymvvm.basecomponent.BaseActivity
import xyz.rakalabs.omnibus.R
import xyz.rakalabs.omnibus.databinding.ActivityAuthBinding
import xyz.rakalabs.omnibus.viewmodel.AuthViewModel
import kotlin.reflect.KClass

class AuthActivity : BaseActivity<ActivityAuthBinding, AuthViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_auth
    override val initViewModel: KClass<AuthViewModel>
        get() = AuthViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
