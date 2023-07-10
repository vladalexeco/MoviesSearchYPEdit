package ru.yandex.practicum.moviessearch.ui.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import ru.yandex.practicum.moviessearch.R
import ru.yandex.practicum.moviessearch.core.navigation.NavigatorHolder
import ru.yandex.practicum.moviessearch.core.navigation.impl.NavigatorImpl
import ru.yandex.practicum.moviessearch.databinding.ActivityRootBinding
import ru.yandex.practicum.moviessearch.ui.movies.MoviesFragment

class RootActivity : AppCompatActivity() {

    private val navigatorHolder: NavigatorHolder by inject()

    // Создали Navigator
    private val navigator = NavigatorImpl(
        fragmentContainerViewId = R.id.rootFragmentContainerView,
        fragmentManager = supportFragmentManager
    )

    private lateinit var binding: ActivityRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRootBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (savedInstanceState == null) {
            navigator.openFragment(MoviesFragment())
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.attachNavigator(navigator)
    }

    // Открепляем Navigator от NavigatorHolder
    override fun onPause() {
        super.onPause()
        navigatorHolder.detachNavigator()
    }
}