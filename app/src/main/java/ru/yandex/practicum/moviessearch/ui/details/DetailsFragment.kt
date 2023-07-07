package ru.yandex.practicum.moviessearch.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import ru.yandex.practicum.moviessearch.R
import ru.yandex.practicum.moviessearch.databinding.FragmentDetailsBinding

class DetailsFragment: Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var tabsMediator: TabLayoutMediator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val poster = requireArguments().getString("poster") ?: ""
        val movieId = requireArguments().getString("movieId") ?: ""

        binding.viewPager.adapter = DetailsViewPagerAdapter(childFragmentManager, lifecycle, poster, movieId)

        tabsMediator = TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = getString(R.string.poster)
                1 -> tab.text = getString(R.string.details)
            }
        }
        tabsMediator.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tabsMediator.detach()
    }

    companion object {
        fun newInstance(poster: String, movieId: String): DetailsFragment {
            return DetailsFragment().apply {
                arguments = bundleOf("poster" to poster, "movieId" to movieId)
            }
        }
    }

}