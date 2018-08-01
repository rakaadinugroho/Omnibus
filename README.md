# Omnibus

[![](https://jitpack.io/v/rakaadinugroho/Omnibus.svg)](https://jitpack.io/#rakaadinugroho/Omnibus)

Omnibus is Starter Pack Library to Build Solid Architecture Apps with MVVM Design Pattern for your Android Application.

### How to Use
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
```gradle
dependencies {
	implementation 'com.github.rakaadinugroho:Omnibus:$OMNIBUS_VERSION'
}
```
### Features

  - Compact Base Component
  - Easy Network Usage
  - Android Architecture Component Support

You can also:
  - Use Utils Component
  - Simple Permission Utils
  
# Sample
## Base Component
You can extends your activities with ``` BaseActivity<YourDataBinding, YourViewModel>``` or if you use Fragment ``` BaseFragment<YourDataBinding, YourViewModel>```
```kotlin
class AuthActivity : BaseActivity<ActivityAuthBinding, AuthViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_auth
    override val initViewModel: KClass<AuthViewModel>
        get() = AuthViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
```
## MVVM
### ViewModel
```kotlin
class AuthViewModel: BaseViewModel<AuthView>() {
	// your action
}
```
### View
```kotlin
interface AuthView : BaseView {
	fun loadUserData()
}
```
### Integration with KOIN
Create Koin Module Component first
```kotlin
val myModule : Module = applicationContext {
    viewModel { AuthViewModel(get()) }
    provide { AuthView() as Repository }
}
```
### Starting KOIN Component
```kotlin
class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(myModule))
    }
}
```

### With JoyMVVM Omnibus
With Omnibus you have to Enjoyable Design Patter, You have'nt to Declare Component Like
```kotlin
val model  = getViewModel<MyViewModel>()
```
or
```kotlin
val model by viewModel<MyViewModel>()
```
**Enjoy with MVVM!**
