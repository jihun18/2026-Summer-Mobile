package kr.hnu.ice.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // 화면에 뷰 바인딩 적용

        // 하단 내비게이션 바 아이템 클릭 리스너 설정
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.navigation_category -> {
                    // TODO: 분류(Category) 프래그먼트 생성 후 교체 예정
                    replaceFragment(CategoryFragment())
                    true
                }
                R.id.navigation_benefits -> {
                    // TODO: 혜택(Benefit) 프래그먼트 생성 후 교체 예정
                    replaceFragment(BenefitFragment())
                    true
                }
                R.id.navigation_scrap -> {
                    // TODO: 스크랩(Scrap) 프래그먼트 생성 후 교체 예정
                    replaceFragment(ScrapFragment())
                    true
                }
                R.id.navigation_my -> {
                    // TODO: MY 프래그먼트 생성 후 교체 예정
                    replaceFragment(MyFragment())
                    true
                }
                else -> false
            }
        }
    }

    // 화면을 부드럽게 갈아 끼워주는 공용 메서드 (FragmentTransaction)
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, fragment)
            .commit()
    }
}