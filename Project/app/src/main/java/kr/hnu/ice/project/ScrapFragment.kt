package kr.hnu.ice.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.databinding.FragmentScrapBinding

class ScrapFragment : Fragment() {

    private var _binding: FragmentScrapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScrapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. 왼쪽 [전체(1)] 탭 클릭 리스너
        binding.tabTotal.setOnClickListener {
            binding.tvTabTotal.apply {
                setTextColor(android.graphics.Color.parseColor("#111111"))
                setTypeface(null, android.graphics.Typeface.BOLD)
            }
            binding.indicatorTotal.visibility = View.VISIBLE

            binding.tvTabFolder.apply {
                setTextColor(android.graphics.Color.parseColor("#888888"))
                setTypeface(null, android.graphics.Typeface.NORMAL)
            }
            binding.indicatorFolder.visibility = View.INVISIBLE

            binding.layoutScrapTotal.visibility = View.VISIBLE
            binding.layoutScrapFolder.visibility = View.GONE
        }

        // 2. 오른쪽 [내폴더(2)] 탭 클릭 리스너
        binding.tabFolder.setOnClickListener {
            binding.tvTabFolder.apply {
                setTextColor(android.graphics.Color.parseColor("#111111"))
                setTypeface(null, android.graphics.Typeface.BOLD)
            }
            binding.indicatorFolder.visibility = View.VISIBLE

            binding.tvTabTotal.apply {
                setTextColor(android.graphics.Color.parseColor("#888888"))
                setTypeface(null, android.graphics.Typeface.NORMAL)
            }
            binding.indicatorTotal.visibility = View.INVISIBLE

            binding.layoutScrapTotal.visibility = View.GONE
            binding.layoutScrapFolder.visibility = View.VISIBLE
        }

        // 3. 새폴더 추가 버튼 클릭 리스너
        binding.btnAddFolder.setOnClickListener {
            Toast.makeText(context, "새폴더 만들기 기능이 활성화됩니다.", Toast.LENGTH_SHORT).show()
        }

        // ★ [해결 완료] layout_onion_recipe ID가 뷰바인딩을 통해 layoutOnionRecipe로 완벽하게 맵핑되었습니다!
        binding.layoutOnionRecipe.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, RecipeDetailFragment())
                .addToBackStack(null) // 백버튼 누르면 스크랩 목록으로 돌아오게 처리
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}