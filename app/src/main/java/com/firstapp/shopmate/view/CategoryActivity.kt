package com.firstapp.shopmate.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import com.firstapp.shopmate.R

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_home)

        val veg = findViewById<LinearLayout>(R.id.categoryVegetable)
        val fruits = findViewById<LinearLayout>(R.id.categoryFruits)
        val meats = findViewById<LinearLayout>(R.id.categoryMeats)
        val dairy = findViewById<LinearLayout>(R.id.categoryDairy)
        val historyButton = findViewById<ImageView>(R.id.historyButton)

        veg.setOnClickListener {
            startActivity(Intent(this, VegetableActivity::class.java))
        }

        fruits.setOnClickListener {
            startActivity(Intent(this, FruitsActivity::class.java))
        }

        meats.setOnClickListener {
            startActivity(Intent(this, MeatsActivity::class.java))
        }

        dairy.setOnClickListener {
            startActivity(Intent(this, DairyActivity::class.java))
        }

        historyButton.setOnClickListener{
            startActivity(intent(this, HistoryActivity::class.java))
        }
    }
}
