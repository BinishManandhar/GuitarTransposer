package com.binish.guitartransposer.utils

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.binish.guitartransposer.R

object AppUtil {
    fun changeStatusBarColor(activity: Activity) {
        val window = activity.window
        val decor = window.decorView
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(
                activity,
                R.color.DarkKhaki
        )
        /*when (position) {
            0 -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                else
                    decor.systemUiVisibility = 0

                window.statusBarColor = ContextCompat.getColor(
                        activity,
                        R.color.
                )
            }
            1 -> {
                window.statusBarColor = ContextCompat.getColor(
                        activity,
                        R.color.colorBluish
                )
                decor.systemUiVisibility = 0
            }
            2 -> {
                window.statusBarColor = ContextCompat.getColor(
                        activity,
                        R.color.color_purple
                )
                decor.systemUiVisibility = 0
            }
        }
    }*/
    }
}