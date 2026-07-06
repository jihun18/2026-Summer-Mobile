package kr.hnu.ice.july06application

import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kr.hnu.ice.july06application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var elapsedTime = 0L
    var initTime = System.currentTimeMillis()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setEnabled(true)
        binding.stopBtn.setEnabled(false)
        binding.startBtn.setOnClickListener {
            binding.chronometer.setBase(SystemClock.elapsedRealtime() + elapsedTime)
            binding.startBtn.setEnabled(false)
            binding.stopBtn.setEnabled(true)
            binding.chronometer.start()

            Toast.makeText(this@MainActivity,
                "시간 특정이 시작되었습니다.", Toast.LENGTH_SHORT).show()
        }

        binding.stopBtn.setOnClickListener {
            elapsedTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.stopBtn.isEnabled = false
            binding.startBtn.isEnabled = true
            binding.chronometer.stop()

            Toast.makeText(this@MainActivity,
                "시간 특정이 종료되었습니다.", Toast.LENGTH_SHORT).show()
        }
        binding.resetBtn.setOnClickListener {
            elapsedTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            // binding.chronometer.stop()
        }

        onBackPressedDispatcher.addCallback(this) {
            if(System.currentTimeMillis() - initTime > 5000) {
                Toast.makeText(this@MainActivity,
                    "5초 이후에 종료할 수 있습니다.", Toast.LENGTH_SHORT).show()
            } else
            finish()
        }
    }
}