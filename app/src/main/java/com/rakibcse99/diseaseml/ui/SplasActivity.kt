package com.rakibcse99.diseaseml.ui

import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rakibcse99.diseaseml.R

class SplasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splas)

        val logo: ImageView = findViewById(R.id.logo)

        // Load animations
        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale)
        val fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fad)

        // Start scale animation
        logo.startAnimation(scaleAnimation)

        // Start fade animation after scale animation ends
        scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                logo.startAnimation(fadeAnimation)
                fadeAnimation.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}

                    override fun onAnimationEnd(animation: Animation) {
                        // Start your main activity
                        val intent = Intent(this@SplasActivity, DiseaseMainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }

                    override fun onAnimationRepeat(animation: Animation) {}
                })
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
    }
}