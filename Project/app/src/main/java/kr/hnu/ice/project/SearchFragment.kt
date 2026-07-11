package kr.hnu.ice.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ★ [핵심 명세] 화면 진입하자마자 입력창에 초점을 맞추고 자판 자동 강제 구동
        binding.etSearchInput.requestFocus()
        binding.etSearchInput.postDelayed({
            if (isAdded) {
                activity?.window?.let { window ->
                    // 윈도우 인셋 컨트롤러를 활용해 IME 자판 레이어를 강제로 Show 시킵니다.
                    WindowInsetsControllerCompat(window, binding.etSearchInput)
                        .show(WindowInsetsCompat.Type.ime())
                }
            }
        }, 250) // 전환 애니메이션 마진 고려 250ms 세팅

        // 상단 뒤로가기 화살표 누르면 홈으로 복귀
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // 키보드 돋보기(검색) 또는 상단 🔍 아이콘 터치 시 액션 리스너
        binding.etSearchInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch()
                true
            } else false
        }
        binding.btnSearchAction.setOnClickListener {
            performSearch()
        }
    }

    private fun performSearch() {
        val query = binding.etSearchInput.text.toString().trim()
        if (query.isNotEmpty()) {
            Toast.makeText(context, "'$query' 상품 및 레시피 통합 검색을 시작합니다!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "검색어를 입력해 주세요.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}