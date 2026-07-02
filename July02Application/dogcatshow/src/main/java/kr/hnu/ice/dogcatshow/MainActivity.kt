package kr.hnu.ice.dogcatshow

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kr.hnu.ice.dogcatshow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dogView.visibility=View.VISIBLE

        binding.dogBtn.setOnClickListener {
            binding.dogView.visibility=View.VISIBLE
            binding.catView.visibility=View.INVISIBLE
        }
        binding.catBtn.setOnClickListener {
            binding.dogView.visibility=View.INVISIBLE
            binding.catView.visibility=View.VISIBLE
        }
    }
}