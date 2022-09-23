package com.abdurrahmanjun.home.presentation.ui.home

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.abdurrahmanjun.core.base.BaseActivity
import com.abdurrahmanjun.home.R
import com.abdurrahmanjun.home.databinding.ActivityHomeBinding
import com.abdurrahmanjun.home.presentation.ui.homefeeds.HomeFeedsFragment
import com.abdurrahmanjun.home.presentation.ui.watchlist.WatchlistFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by AbdurrahmanJun on 23,September,2022
 * https://github.com/Abdurrahmanjun
 * Indonesia, ID.
 */
class HomeActivity :
    BaseActivity<ActivityHomeBinding, HomeViewModel>(ActivityHomeBinding::inflate) {

    private val homeFeedsFragment = HomeFeedsFragment()
    private val watchListFragment = WatchlistFragment()
    private var activeFragment: Fragment = homeFeedsFragment

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override val viewModel: HomeViewModel by viewModel()

    override fun initView() {
        setupFragment()
    }

    private fun setupFragment() {
        // delete all fragment in fragment manager first
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
        // add fragment to fragment manager
        supportFragmentManager.beginTransaction().apply {
            add(binding.container.id, homeFeedsFragment)
            add(binding.container.id, watchListFragment)
            hide(watchListFragment)
        }.commit()
        // set click menu for changing fragment
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    showFragment(homeFeedsFragment)
                    true
                }
                else -> {
                    showFragment(watchListFragment)
                    true
                }
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .hide(activeFragment)
            .show(fragment)
            .commit()
        activeFragment = fragment
    }
}