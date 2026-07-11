package kr.hnu.ice.project

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kr.hnu.ice.project.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        // 1. 원본 스크린샷과 일치하는 실감 나는 가짜 데이터 세팅
        val recentList = listOf(
            Recipe("차돌박이 된장찌개", "★ 4.8"),
            Recipe("김치찌개 정석", "★ 4.7"),
            Recipe("뚝배기 불고기", "★ 4.6")
        )

        val yesterdayList = listOf(
            Recipe("고추장찌개, 참치와 감자를 넣은 고추장찌개", "★ 4.9"),
            Recipe("백종원 고추장찌개 황금레시피 대공개", "★ 5.0"),
            Recipe("얼큰 칼칼한 소고기 고추장찌개", "★ 4.8")
        )

        // 옥수수 요리는 그리드형이므로 균형을 맞추기 위해 4개 배치
        val cornList = listOf(
            Recipe("이렇게 쉬웠다니!! 옥수수보관법", "★ 4.5"),
            Recipe("이렇게 삶으면 대.존.맛! 옥수수 삶는법", "★ 4.6"),
            Recipe("옥수수알갱이분리방법 후두두둑 알갱이", "★ 4.9"),
            Recipe("옥수수가 고개숙이기전에~! 마약콘", "★ 5.0")
        )

        val sharedList = listOf(
            Recipe("명엽채볶음 진짜 밑반찬 끝판왕", "★ 4.9"),
            Recipe("도시락 메뉴로 최고! 깻잎쌈밥", "★ 4.7")
        )

        // 2. 각 리사이클러뷰 레이아웃 매니저 및 어댑터 바인딩
        // (1) 최근 본 레시피 (가로형)
        binding.rvRecentRecipe.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = RecipeAdapter(recentList)
        }

        // (2) 어제 많이 본 요리 (가로형)
        binding.rvYesterdayRecipe.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = RecipeAdapter(yesterdayList)
        }

        // (3) 맛있게 즐기는 옥수수 요리 (★ 원본 스크린샷과 동일한 2열 세로 격자 그리드형!)
        binding.rvCornRecipe.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = RecipeAdapter(cornList)
        }

        // (4) 공유수로 검증된 레시피 (가로형)
        binding.rvSharedRecipe.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = RecipeAdapter(sharedList)
        }

        binding.btnGoFridge.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, FridgeFragment()) // 냉장고 화면으로 교체
                .addToBackStack(null) // ★ 스마트폰 [뒤로가기] 버튼을 누르면 다시 홈 화면으로 복귀하도록 설정
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}