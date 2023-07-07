package ru.yandex.practicum.moviessearch.ui.root

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.yandex.practicum.moviessearch.R
import ru.yandex.practicum.moviessearch.databinding.ActivityRootBinding
import ru.yandex.practicum.moviessearch.ui.movies.MoviesFragment

class RootActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRootBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.rootFragmentContainerView, MoviesFragment())
                .addToBackStack("movies")
                .setReorderingAllowed(true)
                .commit()
        }
    }
}