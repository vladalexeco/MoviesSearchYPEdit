package ru.yandex.practicum.moviessearch.core.navigation.impl

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.yandex.practicum.moviessearch.core.navigation.Navigator

class NavigatorImpl(
    override val fragmentContainerViewId: Int,
    override val fragmentManager: FragmentManager,
) : Navigator {

    override fun openFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(fragmentContainerViewId, fragment)
            .addToBackStack(null)
            .commit()
    }

}