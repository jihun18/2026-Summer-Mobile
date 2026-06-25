package kr.hnu.ice.secondapplicationkt

import android.widget.ImageView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.worldCupImageView).load("https://upload.wikimedia.org/wikipedia/commons/a/ae/FIFA_World_Cup_Trophy_at_National_Football_Museum%2C_Manchester_02.jpg") {
            crossfade(true)
        }
    }
}