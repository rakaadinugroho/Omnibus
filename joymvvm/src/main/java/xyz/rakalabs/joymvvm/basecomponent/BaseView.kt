package xyz.rakalabs.joymvvm.basecomponent

interface BaseView {
    fun onLoading()
    fun onFinished()
    fun onFailed(any: Any)
    fun onSuccess(any: Any, code: Int)
    fun onError(throwable: Throwable)
    fun onErrorFatal(throwable: Throwable)
}