package ru.yandex.practicum.moviessearch.core.navigation.impl

import androidx.fragment.app.Fragment
import ru.yandex.practicum.moviessearch.core.navigation.NavigatorHolder
import ru.yandex.practicum.moviessearch.core.navigation.Router

class RouterImpl : Router {

    override val navigatorHolder: NavigatorHolder = NavigatorHolderImpl()

    override fun openFragment(fragment: Fragment) {
        navigatorHolder.openFragment(fragment)
    }

}