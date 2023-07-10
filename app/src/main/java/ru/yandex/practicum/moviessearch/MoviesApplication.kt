package ru.yandex.practicum.moviessearch

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import ru.yandex.practicum.moviessearch.di.*

class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@MoviesApplication)
            modules(dataModule, repositoryModule, interactorModule, viewModelModule, navigationModule)
        }
    }
}