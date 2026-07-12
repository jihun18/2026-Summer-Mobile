package kr.hnu.ice.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.R // R 클래스 패키지 임포트 명세 고정
import kr.hnu.ice.project.databinding.FragmentMyBinding

class MyFragment : Fragment() {

    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. [상단 프로필 구역] 레시피 등록 캡슐 버튼 클릭 리스너
        // -> 터치 시 내가 쓴 레시피 리스트 / 등록화면(RecipeRegisterFragment)으로 점프
        binding.btnRegisterRecipe.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, RecipeRegisterFragment())
                .addToBackStack(null) // 스마트폰 뒤로가기 키 누르면 다시 마이페이지로 복귀
                .commit()
        }

        // 2. [대시보드 구역] 내가 본 레시피 아이콘 버튼 클릭 리스너
        // -> 터치 시 최근에 구경한 히스토리 목록 화면(RecentViewFragment)으로 점프
        binding.btnRecentRecipes.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, RecentViewFragment())
                .addToBackStack(null) // 뒤로가기 누르면 마이페이지로 안전하게 컴백
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}