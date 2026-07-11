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

        // 1. 왼쪽 [전체(1)] 탭 클릭 시 발동 리스너
        binding.tabTotal.setOnClickListener {
            // 헤더 비주얼 활성화 (Bold + 밑줄 노출)
            binding.tvTabTotal.apply {
                setTextColor(android.graphics.Color.parseColor("#111111"))
                setTypeface(null, android.graphics.Typeface.BOLD)
            }
            binding.indicatorTotal.visibility = View.VISIBLE

            // 내폴더 헤더 비활성화 (Normal색 + 밑줄 제거)
            binding.tvTabFolder.apply {
                setTextColor(android.graphics.Color.parseColor("#888888"))
                setTypeface(null, android.graphics.Typeface.NORMAL)
            }
            binding.indicatorFolder.visibility = View.INVISIBLE

            // 하단 대시보드 리스트 전면 교체
            binding.layoutScrapTotal.visibility = View.VISIBLE
            binding.layoutScrapFolder.visibility = View.GONE
        }

        // 2. 오른쪽 [내폴더(2)] 탭 클릭 시 발동 리스너
        binding.tabFolder.setOnClickListener {
            // 내폴더 헤더 활성화 (Bold + 밑줄 노출)
            binding.tvTabFolder.apply {
                setTextColor(android.graphics.Color.parseColor("#111111"))
                setTypeface(null, android.graphics.Typeface.BOLD)
            }
            binding.indicatorFolder.visibility = View.VISIBLE

            // 전체 헤더 비활성화 (Normal색 + 밑줄 제거)
            binding.tvTabTotal.apply {
                setTextColor(android.graphics.Color.parseColor("#888888"))
                setTypeface(null, android.graphics.Typeface.NORMAL)
            }
            binding.indicatorTotal.visibility = View.INVISIBLE

            // 하단 대시보드 리스트 전면 교체
            binding.layoutScrapTotal.visibility = View.GONE
            binding.layoutScrapFolder.visibility = View.VISIBLE
        }

        // 3. 새폴더 버튼 팝업용 임시 알림
        binding.btnAddFolder.setOnClickListener {
            Toast.makeText(context, "새폴더 만들기 기능이 활성화됩니다.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}