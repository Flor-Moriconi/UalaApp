package com.florm.ualaapp.injectionDependency

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AndroidSupportInjectionModule::class),(ApplicationModule::class), (ActivityModule::class)])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: AppController): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: AppController)
}