package kr.hnu.ice.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.databinding.FragmentRecentViewBinding

class RecentViewFragment : Fragment() {

    private var _binding: FragmentRecentViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecentViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 상단 화살표 누르면 다시 마이페이지로 안전 귀환
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // 편집 우측 토글 피드백
        binding.btnEdit.setOnClickListener {
            Toast.makeText(context, "히스토리 편집 모드가 활성화됩니다.", Toast.LENGTH_SHORT).show()
        }

        // 양파볶음밥 줄을 누르면 7단계 디테일 화면으로 점프
        binding.layoutRecipeOnion.setOnClickListener {
            parentFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container, RecipeDetailFragment())
                    .addToBackStack(null)
                    .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
