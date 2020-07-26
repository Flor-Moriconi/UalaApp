package com.florm.ualaapp.injectionDependency

import com.florm.ualaapp.views.DetailActivity
import com.florm.ualaapp.views.ListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeListActivity(): ListActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailActivity

}