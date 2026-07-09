package kr.hnu.ice.fragmentapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kr.hnu.ice.fragmentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstBtn.isEnabled = false
        
        binding.firstBtn.setOnClickListener {
            binding.firstBtn.isEnabled = false
            binding.secondBtn.isEnabled = true
            binding.thirdBtn.isEnabled = true
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2, FirstFragment())
                .commit()
        }

        binding.secondBtn.setOnClickListener {
            binding.firstBtn.isEnabled = true
            binding.secondBtn.isEnabled = false
            binding.thirdBtn.isEnabled = true
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2, SecondFragment())
                .commit()
        }

        binding.thirdBtn.setOnClickListener {
            binding.firstBtn.isEnabled = true
            binding.secondBtn.isEnabled = true
            binding.thirdBtn.isEnabled = false
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2, ThirdFragment())
                .commit()
        }
    }
}