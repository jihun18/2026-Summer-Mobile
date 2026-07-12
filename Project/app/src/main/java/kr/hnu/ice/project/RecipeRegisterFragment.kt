package kr.hnu.ice.project

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.R // R 리소스 매칭 완벽 고정
import kr.hnu.ice.project.databinding.FragmentRecipeRegisterBinding

class RecipeRegisterFragment : Fragment() {

    private var _binding: FragmentRecipeRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 상단 화살표 누르면 다시 마이페이지 백스택 리턴 복귀
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // [공개중] 상단 가상 탭 클릭 액션 인터랙션
        binding.tabPublic.setOnClickListener {
            binding.tvTabPublic.setTextColor(Color.parseColor("#70A150"))
            binding.tvTabPublic.setTypeface(null, Typeface.BOLD)
            binding.indicatorPublic.visibility = View.VISIBLE

            binding.tvTabDraft.setTextColor(Color.parseColor("#888888"))
            binding.tvTabDraft.setTypeface(null, Typeface.NORMAL)
            binding.indicatorDraft.visibility = View.INVISIBLE
        }

        // [작성중] 상단 가상 탭 클릭 액션 인터랙션
        binding.tabDraft.setOnClickListener {
            binding.tvTabDraft.setTextColor(Color.parseColor("#70A150"))
            binding.tvTabDraft.setTypeface(null, Typeface.BOLD)
            binding.indicatorDraft.visibility = View.VISIBLE

            binding.tvTabPublic.setTextColor(Color.parseColor("#888888"))
            binding.tvTabPublic.setTypeface(null, Typeface.NORMAL)
            binding.indicatorPublic.visibility = View.INVISIBLE
        }

        // 하단 마스터 액션 등록 토스트 바 서식 알림
        binding.btnBottomRegister.setOnClickListener {
            Toast.makeText(context, "새로운 래시피 작성 위자드가 기동됩니다!", Toast.LENGTH_SHORT).show()
        }

        binding.btnCustomerCenter.setOnClickListener {
            Toast.makeText(context, "고객센터 1:1 대화방으로 연결합니다.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}