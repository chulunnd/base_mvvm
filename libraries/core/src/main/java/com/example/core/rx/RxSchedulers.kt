package com.example.core.rx

import dagger.Module
import io.reactivex.Scheduler

@Module
interface RxSchedulers {
    fun runOnBackground(): Scheduler
    fun io(): Scheduler
    fun compute(): Scheduler
    fun androidThread(): Scheduler?
    fun internet(): Scheduler
}