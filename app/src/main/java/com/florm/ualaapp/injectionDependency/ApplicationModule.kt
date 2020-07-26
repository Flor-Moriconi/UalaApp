package com.florm.ualaapp.injectionDependency

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideContext(appController: AppController): Context {
        return appController.applicationContext
    }
}