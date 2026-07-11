package kr.hnu.ice.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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

        // 💡 [해결] btn_register_recipe 가 btnRegisterRecipe 로 자동 스위칭되었습니다!
        binding.btnRegisterRecipe.setOnClickListener {
            Toast.makeText(context, "나만의 명품 레시피 등록 기능이 활성화됩니다!", Toast.LENGTH_SHORT).show()
        }

        binding.btnRecentRecipes.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, RecentViewFragment())
                .addToBackStack(null) // 뒤로가기 누르면 다시 마이페이지로 스무스하게 복귀 가능
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}