package xyz.rakalabs.joymvvm.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.EditText

/*
Use to launch activity from Activity with Request Code or Not
launchActivity<OriginActivity>(requestCode = CODE_CALLBACK) { add flag or extras here }
 */
inline fun <reified T: Any> Activity.launchActivity(requestCode: Int = -1, options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) startActivityForResult(intent, requestCode, options)
    else startActivityForResult(intent, requestCode)
}

inline fun <reified T: Any> Context.launchActicity(options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) startActivity(intent, options)
    else startActivity(intent)
}

inline fun <reified T: Any> newIntent(context: Context) : Intent = Intent(context, T::class.java)

/*
Use to check is valid email from some string, with Boolean callback
"email@mail.com".isValidEmail()
 */
fun String.isValidEmail(): Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

/*
Use to go to specific fragment with easier
 */
fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commitAllowingStateLoss()
}

/*
Its from Specific EditText, to easier validate with specific validator you need
Example:
usernameInput
    .validateSpecific( {s -> s.isNotEmpty() },"Please fill data", { callback -> "validation $callback" })
 */
fun EditText.validateSpecific(validator: (String) -> Boolean, message: String, listener: (Boolean) -> Unit) {
    this.afterTextChanged {
        this.error = if (validator(it)) null else message
        this.requestFocus()
    }
    this.error = if (validator(this.text.toString())) null else message
    if (!validator(this.text.toString())) this.requestFocus()
    listener(validator(this.text.toString()))
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged.invoke(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) { }
    })
}


/*
Use to rotate bitmap, easily you can rotate you Bitmap file like
myPicture.rotate(90f) to clockwise rotation
 */
fun Bitmap.rotate(degrees: Float): Bitmap {
    val matrix = Matrix().apply { postRotate(degrees) }
    return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
}