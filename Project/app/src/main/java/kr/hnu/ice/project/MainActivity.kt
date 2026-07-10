package kr.hnu.ice.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 1. Step 2에서 설정한 뷰바인딩(ViewBinding) 객체 선언
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 2. 뷰바인딩 초기화 및 레이아웃 설정 (findViewById를 대체)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 3. 앱이 처음 켜졌을 때 기본 화면을 'HomeFragment'로 지정
        if (savedInstanceState == null) {
            changeFragment(HomeFragment())
        }

        // 4. 하단 탭 버튼 클릭 시 동작하는 리스너 설정
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    changeFragment(HomeFragment())
                    true
                }
                R.id.nav_category -> {
                    changeFragment(CategoryFragment())
                    true
                }
                R.id.nav_benefit -> {
                    changeFragment(BenefitFragment())
                    true
                }
                R.id.nav_scrap -> {
                    changeFragment(ScrapFragment())
                    true
                }
                R.id.nav_my -> {
                    changeFragment(MyFragment())
                    true
                }
                else -> false
            }
        }
    }

    // 5. main_container 영역에 프래그먼트를 동적으로 갈아끼우는 함수
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
    }
}