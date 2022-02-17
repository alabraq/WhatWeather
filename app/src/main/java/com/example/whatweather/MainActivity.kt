package com.example.whatweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatweather.ui.main.MainFragment
import com.example.whatweather.ui.main.SecondFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.containerMainFragment, MainFragment.newInstance())
            add(R.id.containerSecondFragment, SecondFragment.newInstance())
            commit()
        }
    }
}