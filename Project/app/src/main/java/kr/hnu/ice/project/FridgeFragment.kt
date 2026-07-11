package kr.hnu.ice.project

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import com.google.android.material.chip.ChipGroup
import kr.hnu.ice.project.databinding.FragmentFridgeBinding

class FridgeFragment : Fragment() {

    private var _binding: FragmentFridgeBinding? = null
    private val binding get() = _binding!!

    private val fridgeKeywords = mutableListOf<String>()
    private val excludeKeywords = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFridgeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 초기 최근 검색어 기본 마킹
        addRecentSearchChip("콩나물")

        // 1. 외곽 상자 클릭 시 입력창으로 포커스 및 최신 엔진 키보드 팝업
        binding.layoutFridgeBox.setOnClickListener {
            focusAndShowKeyboard(binding.etFridgeInput)
        }
        binding.layoutExcludeBox.setOnClickListener {
            focusAndShowKeyboard(binding.etExcludeInput)
        }

        // 키보드 완료 버튼 클릭 시 동적 칩 가공 로직
        binding.etFridgeInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val text = binding.etFridgeInput.text.toString().trim()
                if (text.isNotEmpty() && !fridgeKeywords.contains(text)) {
                    fridgeKeywords.add(text)
                    createDynamicChip(binding.cgFridgeChips, text, isFridge = true)
                    binding.etFridgeInput.text.clear()
                }
                true
            } else false
        }

        binding.etExcludeInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val text = binding.etExcludeInput.text.toString().trim()
                if (text.isNotEmpty() && !excludeKeywords.contains(text)) {
                    excludeKeywords.add(text)
                    createDynamicChip(binding.cgExcludeChips, text, isFridge = false)
                    binding.etExcludeInput.text.clear()
                }
                true
            } else false
        }

        // 전체삭제 및 뒤로가기 버튼 리스너들
        binding.btnBack.setOnClickListener { parentFragmentManager.popBackStack() }

        binding.btnClearFridge.setOnClickListener {
            fridgeKeywords.clear()
            binding.cgFridgeChips.removeAllViews()
        }
        binding.btnClearExclude.setOnClickListener {
            excludeKeywords.clear()
            binding.cgExcludeChips.removeAllViews()
        }
        binding.btnClearRecent.setOnClickListener {
            binding.cgRecentChips.removeAllViews()
        }

        // 최종 검색 버튼 클릭 이벤트
        binding.btnSearch.setOnClickListener {
            if (fridgeKeywords.isEmpty()) {
                Toast.makeText(context, "최소 한 개 이상의 재료를 입력해 주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            for (keyword in fridgeKeywords) {
                addRecentSearchChip(keyword)
            }
            Toast.makeText(context, "${fridgeKeywords.size}개의 재료로 최적의 레시피를 매칭합니다!", Toast.LENGTH_SHORT).show()
        }
    }

    // ★ [버그 해결] 부모 포커스 방해 요소가 사라진 상태에서 Window 단에 자판 강제 호출 명령 하달
    private fun focusAndShowKeyboard(editText: EditText) {
        editText.requestFocus()
        editText.postDelayed({
            if (isAdded) {
                val window = activity?.window
                if (window != null) {
                    // 시스템 자판 레이어(IME)를 창 위에 무조건 띄워버리는 최신 정석 API
                    WindowInsetsControllerCompat(window, editText).show(WindowInsetsCompat.Type.ime())
                }
            }
        }, 100)
    }

    private fun createDynamicChip(chipGroup: ChipGroup, name: String, isFridge: Boolean) {
        val chipView = LayoutInflater.from(context).inflate(R.layout.item_chip_tag, chipGroup, false)
        val tvName = chipView.findViewById<TextView>(R.id.tv_chip_name)
        val btnDelete = chipView.findViewById<TextView>(R.id.btn_delete_chip)

        tvName.text = name

        if (isFridge) {
            chipView.setBackgroundResource(R.drawable.shape_edittext_fridge_green)
            chipView.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#F4F8F0"))
        }

        btnDelete.setOnClickListener {
            chipGroup.removeView(chipView)
            if (isFridge) fridgeKeywords.remove(name)
            else excludeKeywords.remove(name)
        }
        chipGroup.addView(chipView)
    }

    private fun addRecentSearchChip(name: String) {
        for (i in 0 until binding.cgRecentChips.childCount) {
            val child = binding.cgRecentChips.getChildAt(i)
            val tv = child.findViewById<TextView>(R.id.tv_chip_name)
            if (tv?.text?.toString() == name) return
        }

        val chipView = LayoutInflater.from(context).inflate(R.layout.item_chip_tag, binding.cgRecentChips, false)
        val tvName = chipView.findViewById<TextView>(R.id.tv_chip_name)
        val btnDelete = chipView.findViewById<TextView>(R.id.btn_delete_chip)

        tvName.text = name
        btnDelete.setOnClickListener {
            binding.cgRecentChips.removeView(chipView)
        }
        binding.cgRecentChips.addView(chipView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}