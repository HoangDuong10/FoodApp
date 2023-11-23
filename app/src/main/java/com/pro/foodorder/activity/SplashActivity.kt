package com.pro.foodorder.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.pro.foodorder.R
import com.pro.foodorder.constant.GlobalFunction.gotoMainActivity
import com.pro.foodorder.constant.GlobalFunction.startActivity
import com.pro.foodorder.prefs.DataStoreManager.Companion.user
import com.pro.foodorder.utils.StringUtil.isEmpty


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({ goToNextActivity() }, 2000)
    }

    private fun goToNextActivity() {
        if (user != null && !isEmpty(user!!.email)) {
            gotoMainActivity(this)
        } else {
            startActivity(this, SignInActivity::class.java)
        }
        finish()
    }
}