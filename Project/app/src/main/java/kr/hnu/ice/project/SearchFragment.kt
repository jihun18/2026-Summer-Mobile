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

        // 화면 진입하자마자 입력창에 초점을 맞추고 자판 자동 강제 구동
        binding.etSearchKeyword.requestFocus()
        binding.etSearchKeyword.postDelayed({
            if (isAdded) {
                activity?.window?.let { window ->
                    WindowInsetsControllerCompat(window, binding.etSearchKeyword)
                        .show(WindowInsetsCompat.Type.ime())
                }
            }
        }, 250) // 전환 애니메이션 마진 고려 250ms 세팅

        // 💡 [복구 완료] 왼쪽 뒤로가기 화살표(←) 누르면 안전하게 홈 화면 백스택 탈출 복귀
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // 키보드 돋보기(검색) 클릭 시 액션 리스너
        binding.etSearchKeyword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch()
                true
            } else false
        }

        // 실물 돋보기 이미지 버튼 리스너 연동
        binding.btnSearchClick.setOnClickListener {
            performSearch()
        }

        // 새 블랙 마이크 아이콘 클릭 리스너 주입
        binding.btnVoiceSearchClick.setOnClickListener {
            Toast.makeText(context, "음성 인식 검색 기능이 활성화되었습니다. 말씀해 주세요! 🎙️", Toast.LENGTH_SHORT).show()
        }
    }

    private fun performSearch() {
        val query = binding.etSearchKeyword.text.toString().trim()
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