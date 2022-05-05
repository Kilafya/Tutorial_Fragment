package com.example.tutorial_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tutorial_fragment.databinding.ActivityMainBinding
import com.github.javafaker.Faker

class MainActivity : AppCompatActivity() {

    private val faker = Faker.instance()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = ContentFragment.newInstance(
                counterValue = 1,
                quote = createQuote()
            )
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }

    fun createQuote(): String = faker.harryPotter().quote()

    fun getScreenNumber() = supportFragmentManager.backStackEntryCount + 1
}