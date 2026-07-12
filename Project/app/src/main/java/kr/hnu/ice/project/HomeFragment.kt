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

        // 1. 데이터 리스트 세팅 (모든 생성자에 3번째 인자로 이미지 리소스 ID 삽입)
        val recentList = listOf(
            Recipe("차돌박이 된장찌개", "4.8 (4) · 코난", R.drawable.ic_chadol),
            Recipe("김치찌개 정석", "★ 4.7", R.drawable.ic_kimchi), // 임시 아이콘
            Recipe("뚝배기 불고기", "★ 4.6", R.drawable.ic_ttuk)
        )

        val yesterdayList = listOf(
            Recipe("고추장찌개, 참치와 감자를 넣은 고추장찌개", "★ 4.9", R.drawable.ic_gochujang),
            Recipe("백종원 고추장찌개 황금레시피 대공개", "★ 5.0", R.drawable.ic_gochujang2),
            Recipe("얼큰 칼칼한 소고기 고추장찌개", "★ 4.8", R.drawable.ic_gochujang3)
        )

        val cornList = listOf(
            Recipe("이렇게 쉬웠다니!! 옥수수보관법", "★ 4.5", R.drawable.ic_oksusu1),
            Recipe("이렇게 삶으면 대.존.맛! 옥수수 삶는법", "★ 4.6", R.drawable.ic_oksusu2),
            Recipe("옥수수알갱이분리방법 후두두둑 알갱이", "★ 4.9", R.drawable.ic_oksusu3),
            Recipe("옥수수가 고개숙이기전에~! 마약콘", "★ 5.0", R.drawable.ic_oksusu4)
        )

        val sharedList = listOf(
            Recipe("명엽채볶음 진짜 밑반찬 끝판왕", "★ 4.9", R.drawable.ic_myeong),
            Recipe("도시락 메뉴로 최고! 깻잎쌈밥", "★ 4.7", R.drawable.ic_kkat)
        )

        // 2. 어댑터 연결
        binding.rvRecentRecipe.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = RecipeAdapter(recentList)
        }
        binding.rvYesterdayRecipe.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = RecipeAdapter(yesterdayList)
        }
        binding.rvCornRecipe.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = RecipeAdapter(cornList)
        }
        binding.rvSharedRecipe.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = RecipeAdapter(sharedList)
        }

        // 버튼 클릭 이벤트들...
        binding.btnGoFridge.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, FridgeFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.layoutSearchBarContainer.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, SearchFragment())
                .addToBackStack(null)
                .commit()
        }
        binding.btnGoShoppingMemo.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, ShoppingMemoFragment())
                .addToBackStack(null)
                .commit()
        }

        // 전체보기 ∨ 클릭 시 추가 아이콘 표시/숨기기 토글
        binding.btnViewAll.setOnClickListener {
            if (binding.layoutMoreIcons.visibility == View.GONE) {
                binding.layoutMoreIcons.visibility = View.VISIBLE
                binding.btnViewAll.text = "접기 ∧"
            } else {
                binding.layoutMoreIcons.visibility = View.GONE
                binding.btnViewAll.text = "전체보기 ∨"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}