package com.firstapp.shopmate  // replace with your package name

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        // Find views
        val circle = findViewById<View>(R.id.logo_circle)
        val text = findViewById<TextView>(R.id.logo_text)

        // Optional: set font programmatically if XML fails
//        val typeface = ResourcesCompat.getFont(this, R.font.JollyLodgerRegular)
//        text.typeface = typeface

        // Load animation
        val wipeAnim = AnimationUtils.loadAnimation(this, R.anim.wipe_in)

        // Start animation
        circle.startAnimation(wipeAnim)
        text.startAnimation(wipeAnim)

        // Go to MainActivity after animation ends
        wipeAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                startActivity(Intent(this@IntroActivity, MainActivity::class.java))
                finish()
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}
