package com.example.core.base

import android.content.Intent
import android.os.IBinder
import dagger.android.DaggerService
import io.reactivex.disposables.CompositeDisposable

open class BaseService : DaggerService() {

    protected val compositeDisposable = CompositeDisposable()

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

}