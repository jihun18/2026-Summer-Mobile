package kr.hnu.ice.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.databinding.FragmentBenefitBinding

class BenefitFragment : Fragment() {

    private var _binding: FragmentBenefitBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBenefitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 향후 이곳에 포인트 충전 팝업이나 쿠폰 구매 리너스를 이식해 줄 예정입니다!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}