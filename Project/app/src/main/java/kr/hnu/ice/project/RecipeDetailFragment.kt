package kr.hnu.ice.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.databinding.FragmentRecipeDetailBinding

class RecipeDetailFragment : Fragment() {

    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 고정형 상단 백버튼 화살표 터치 시 목록으로 안전 귀환
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // 가로 스와이프 리스트 클릭 액션 가상 시뮬레이션 리스너
        binding.b1.setOnClickListener { Toast.makeText(context, "양파 구매 페이지로 이동합니다.", Toast.LENGTH_SHORT).show() }
        binding.b2.setOnClickListener { Toast.makeText(context, "슬라이스 마늘 구매 페이지로 이동합니다.", Toast.LENGTH_SHORT).show() }
        binding.b3.setOnClickListener { Toast.makeText(context, "밥 구매 페이지로 이동합니다.", Toast.LENGTH_SHORT).show() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}