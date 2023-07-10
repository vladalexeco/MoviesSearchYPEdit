package ru.yandex.practicum.moviessearch.core.navigation.impl

import androidx.fragment.app.Fragment
import ru.yandex.practicum.moviessearch.core.navigation.Navigator
import ru.yandex.practicum.moviessearch.core.navigation.NavigatorHolder

class NavigatorHolderImpl : NavigatorHolder {

    private var navigator: Navigator? = null

    override fun attachNavigator(navigator: Navigator) {
        this.navigator = navigator
    }

    override fun detachNavigator() {
        this.navigator = null
    }

    override fun openFragment(fragment: Fragment) {
        navigator?.openFragment(fragment)
    }

}