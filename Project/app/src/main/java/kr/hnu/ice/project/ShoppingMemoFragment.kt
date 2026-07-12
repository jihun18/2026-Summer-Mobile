package kr.hnu.ice.project

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kr.hnu.ice.project.databinding.FragmentShoppingMemoBinding

class ShoppingMemoFragment : Fragment() {

    private var _binding: FragmentShoppingMemoBinding? = null
    private val binding get() = _binding!!

    // 투트랙 실시간 데이터 저장소 분할 명세
    private val activeMemos = mutableListOf<String>()
    private val completedMemos = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoppingMemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // 1. 재료 신규 추가 리스너
        binding.btnAddMemo.setOnClickListener {
            val text = binding.etMemoInput.text.toString().trim()
            if (text.isNotEmpty()) {
                if (!activeMemos.contains(text) && !completedMemos.contains(text)) {
                    activeMemos.add(text)
                    binding.etMemoInput.text.clear()
                    buildAndRenderLists() // 리스트 재연동 그리기
                } else {
                    Toast.makeText(context, "이미 장보기 목록에 있는 재료입니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "상품명을 입력해 주세요!", Toast.LENGTH_SHORT).show()
            }
        }

        // 2. 장보기 목록 전체 비우기
        binding.btnClearAllMemo.setOnClickListener {
            activeMemos.clear()
            buildAndRenderLists()
        }

        // 3. 구매완료 목록 전체 비우기
        binding.btnClearAllCompleted.setOnClickListener {
            completedMemos.clear()
            buildAndRenderLists()
        }
    }

    // 양쪽 어레이 데이터를 기반으로 컨테이너 청소 후 로우 레이아웃을 완전히 새로 정렬해 주는 통합 렌더러
    private fun buildAndRenderLists() {
        // 기존 뷰 트리 깨끗하게 청소
        binding.layoutMemoItemsContainer.removeAllViews()
        binding.layoutCompletedItemsContainer.removeAllViews()

        // 미완료 아이템 그리기
        for (item in activeMemos) {
            val row = createDynamicRow(item, isCompleted = false)
            binding.layoutMemoItemsContainer.addView(row)
        }

        // 완료 아이템 그리기
        for (item in completedMemos) {
            val row = createDynamicRow(item, isCompleted = true)
            binding.layoutCompletedItemsContainer.addView(row)
        }

        // 최종 상태 머신 스위칭 카운터 갱신
        val activeCount = activeMemos.size
        val completedCount = completedMemos.size
        val totalCount = activeCount + completedCount

        binding.tvMemoTitleCount.text = "장보기 목록 ($activeCount)"
        binding.tvCompletedTitleCount.text = "구매완료 목록 ($completedCount)"

        // 1구역: 장보기 목록의 3단 변신 토글 분기 수식
        if (totalCount == 0) {
            // 진짜 아무것도 없을 때 (이미지 1 상태)
            binding.layoutEmptyView.visibility = View.VISIBLE
            binding.layoutAllCompletedView.visibility = View.GONE
            binding.btnClearAllMemo.visibility = View.GONE
            binding.tvActiveTip.visibility = View.GONE
        } else if (activeCount == 0) {
            // 담긴 건 있는데 전부 체크 완료해서 남은 장보기가 없을 때 (이미지 2 상태)
            binding.layoutEmptyView.visibility = View.GONE
            binding.layoutAllCompletedView.visibility = View.VISIBLE
            binding.btnClearAllMemo.visibility = View.GONE
            binding.tvActiveTip.visibility = View.GONE
        } else {
            // 살 게 남아있어서 목록 리스트가 활성화되어야 할 때
            binding.layoutEmptyView.visibility = View.GONE
            binding.layoutAllCompletedView.visibility = View.GONE
            binding.btnClearAllMemo.visibility = View.VISIBLE
            binding.tvActiveTip.visibility = View.VISIBLE
        }

        // 2구역: 구매 완료 영역 토글 노출 분기
        if (completedCount == 0) {
            binding.layoutCompletedSectionWrapper.visibility = View.GONE
        } else {
            binding.layoutCompletedSectionWrapper.visibility = View.VISIBLE
        }
    }

    // 체크 박스 터치 시 데이터가 쇽쇽 이동하는 인터랙션 로우 팩토리
    private fun createDynamicRow(name: String, isCompleted: Boolean): View {
        val context = requireContext()
        val density = resources.displayMetrics.density
        val dpToPx = { dp: Float -> (dp * density).toInt() }

        val rowLayout = RelativeLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                dpToPx(48f) // 고정 높이 부여로 겹침 현상 방지
            ).apply {
                setMargins(0, 0, 0, 0)
            }
            setPadding(dpToPx(4f), 0, dpToPx(4f), 0)
            setBackgroundColor(Color.WHITE)
        }

        // 체크 서클 그래픽 동적 드로잉
        val circleDrawable = GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            // 완료 상태면 원본의 예쁜 초록색(#557733), 미완료면 연회색(#EAEAEA) 장착
            setColor(Color.parseColor(if (isCompleted) "#557733" else "#EAEAEA"))
        }

        // 1. 좌측 원형 체크 버튼
        val ivCheck = TextView(context).apply {
            id = View.generateViewId()
            text = "✓"
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 13f)
            gravity = Gravity.CENTER
            // 완료 상태면 백색 체크, 미완료면 흐린 회색 체크로 완벽 분기
            setTextColor(Color.parseColor(if (isCompleted) "#FFFFFF" else "#BBBBBB"))
            background = circleDrawable

            val size = dpToPx(24f)
            val params = RelativeLayout.LayoutParams(size, size).apply {
                addRule(RelativeLayout.ALIGN_PARENT_LEFT)
                addRule(RelativeLayout.CENTER_VERTICAL)
            }
            layoutParams = params
        }

        // 2. 중앙 텍스트 상품 명세
        val tvName = TextView(context).apply {
            id = View.generateViewId()
            text = name
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
            // 완료 상태면 연한 회색 처리, 미완료면 찐한 검은색 처리
            setTextColor(Color.parseColor(if (isCompleted) "#888888" else "#222222"))

            val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                addRule(RelativeLayout.RIGHT_OF, ivCheck.id)
                addRule(RelativeLayout.CENTER_VERTICAL)
                leftMargin = dpToPx(12f)
            }
            layoutParams = params
        }

        // 3. 우측 쓰레기통 영구 파괴 버튼
        val btnDelete = TextView(context).apply {
            text = "🗑️"
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            gravity = Gravity.CENTER

            // 💡 [버그 대박멸] MATCH_PARENT 높이를 WRAP_CONTENT로 전면 수정하여 비정상적으로 팅기던 버그를 완벽 수정했습니다!
            val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
                addRule(RelativeLayout.CENTER_VERTICAL)
            }
            layoutParams = params

            setOnClickListener {
                if (isCompleted) completedMemos.remove(name) else activeMemos.remove(name)
                buildAndRenderLists()
            }
        }

        // 하단 얇은 내부 분할 경계선
        val bottomDivider = View(context).apply {
            setBackgroundColor(Color.parseColor("#F5F5F5"))
            val params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, dpToPx(1f)
            ).apply {
                addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
            }
            layoutParams = params
        }

        // 💡 [양방향 동적 이동 리스너] 체크 박스나 글씨 영역을 누르면 위아래 리스트 스택으로 마법처럼 쇽쇽 무브먼트!
        val switchListAction = View.OnClickListener {
            if (isCompleted) {
                // 완료 목록에 있던 걸 누르면 다시 일반 목록으로 롤백 복구
                completedMemos.remove(name)
                activeMemos.add(name)
            } else {
                // 일반 목록에 있던 걸 누르면 완료 목록으로 패스 이동
                activeMemos.remove(name)
                completedMemos.add(name)
            }
            buildAndRenderLists() // 인터랙션 즉시 새로고침 반영
        }

        ivCheck.setOnClickListener(switchListAction)
        tvName.setOnClickListener(switchListAction)

        rowLayout.addView(ivCheck)
        rowLayout.addView(tvName)
        rowLayout.addView(btnDelete)
        rowLayout.addView(bottomDivider)

        return rowLayout
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}