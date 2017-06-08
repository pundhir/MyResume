package com.colortabz.resume

import android.os.Bundle
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log


class MainActivity : AppCompatActivity() {

    private var mAboutMeFrag: AboutMeFragment? = null
    private var mExperienceFrag: ExperienceFragment? = null
    private var mProjectFrag : ProjectFragment? = null
    private var mInterestFrag : InterestFragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.about_me -> {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mAboutMeFrag)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }

            R.id.experience -> {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mExperienceFrag)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.projects -> {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mProjectFrag)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }

            R.id.test -> {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, mInterestFrag)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAboutMeFrag = AboutMeFragment.newInstance()
        mExperienceFrag = ExperienceFragment.newInstance()
        mProjectFrag = ProjectFragment.newInstance()
        mInterestFrag = InterestFragment.newInstance()


        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        disableShiftMode(navigation)

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, mAboutMeFrag)
                .commit()

    }

    /**
     *
     */
    private fun disableShiftMode(view: BottomNavigationView) {
        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        try {
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0..menuView.childCount - 1) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView
                item.setShiftingMode(false)
                // set once again checked value, so view will be updated
                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            Log.e("BNVHelper", "Unable to get shift mode field", e)
        } catch (e: IllegalAccessException) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e)
        }

    }
}
