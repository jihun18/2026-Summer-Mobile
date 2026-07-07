package kr.hnu.ice.july07application

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kr.hnu.ice.july07application.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val where = intent.getStringExtra("where")
        val value = intent.getStringExtra("value", 0)
        binding.finish2nd.setOnClickListener {
            Toast.makeText(this, "SecondActivity 종료", Toast.LENGTH_LONG).show()
            finish()
        }
        binding.tothirdBtn.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
        binding.toforthBtn.setOnClickListener {
            val intent = Intent(this, ForthActivity::class.java)
            startActivity(intent) }
    }
}