package com.abousalem.hanginkotlin.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.abousalem.hanginkotlin.R
import com.abousalem.hanginkotlin.extenstion.isOnline
import com.abousalem.hanginkotlin.view.auth.LoginActivity

class SplashActivity : AppCompatActivity() {

    private var handler: Handler? = null
    private val SPLASH_DELAY: Long = 3000

    private val runnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        checkInternet()
        handler = Handler()
        handler!!.postDelayed(runnable, SPLASH_DELAY)
    }

    private fun checkInternet() = if (isOnline()) {
        Toast.makeText(this, getString(R.string.connected), Toast.LENGTH_LONG).show()
    } else {
        Toast.makeText(this, getString(R.string.no_internet_connection), Toast.LENGTH_LONG).show()
    }
}
