package kr.hnu.ice.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 여기에 나중에 특정 카테고리(예: '밑반찬')를 클릭했을 때
        // 레시피 결과 리스트 화면으로 이동하는 온클릭 리스너를 달 예정입니다!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}