package com.cassiano.starwars.extension

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

//region --- Single ---
private fun <T> Single<T>.subscribeOnIo(): Single<T> = subscribeOn(Schedulers.io())
private fun <T> Single<T>.observeOnMainThread(): Single<T> = observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.saveMainThread(): Single<T> = subscribeOnIo().observeOnMainThread()