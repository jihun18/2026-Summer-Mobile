package kr.hnu.ice.pickerdialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kr.hnu.ice.pickerdialog.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dateBtn.setOnClickListener {
            val cal = Calendar.getInstance()
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)

            // 생성자에 Context, 리스너, 연, 월, 일을 모두 전달해야 합니다.
            DatePickerDialog(this, { _, selectedYear, selectedMonth, dayOfMonth ->
                binding.dateText.text = "선택한 날짜는 ${selectedYear}년 ${selectedMonth + 1}월 ${dayOfMonth}일 입니다."
            }, year, month, day).show()
        }

        // 2. 시간 선택 버튼 클릭 리스너
        binding.timeBtn.setOnClickListener {
            val cal = Calendar.getInstance()
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val minute = cal.get(Calendar.MINUTE)

            // 생성자에 Context, 리스너, 시, 분, 24시간형식여부(Boolean)를 모두 전달해야 합니다.
            TimePickerDialog(this, { _, hourOfDay, selectedMinute ->
                binding.timeText.text = "선택한 시간은 ${hourOfDay}시 ${selectedMinute}분 입니다."
            }, hour, minute, true).show() // true는 24시간 형식 표기형태입니다.
        }

        binding.dlgBtn.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("알림")
                setMessage("기본 대화상자입니다.")
                setPositiveButton("확인") { _, _ ->
                    binding.dateText.text = "확인 버튼을 눌렀습니다."
                }
                setNegativeButton("취소") { _, _ ->
                    binding.dateText.text = "취소 버튼을 눌렀습니다."
                }
                show()
            }
        }

        binding.alertBtn.setOnClickListener {
            val dlg = AlertDialog.Builder(this)
                .setTitle("알림")
                .setMessage("기본 대화상자입니다.")
                .setPositiveButton("확인") { _, _ ->
                    binding.dateText.text = "확인 버튼을 눌렀습니다."
                }
                .setNegativeButton("취소") { _, _ ->
                    binding.dateText.text = "취소 버튼을 눌렀습니다."
                }
                .create()
            dlg.show()
        }
    }
}