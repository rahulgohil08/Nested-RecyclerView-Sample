package com.theworld.androidtemplatewithnavcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.theworld.androidtemplatewithnavcomponents.utils.SharedPrefManager
import com.theworld.androidtemplatewithnavcomponents.utils.startNewActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({

            if (sharedPrefManager.getBoolean("is_login")) {
                startNewActivity(MainActivity::class.java)
            } else {
                startNewActivity(LoginActivity::class.java)
            }
            finish()
        }, 2000)
    }
}