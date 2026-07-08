# July08Application 학습 정리

**날짜:** 2026년 7월 8일

## 1. 프로젝트 개요
안드로이드의 기본적인 UI 구성 요소와 이벤트 처리, 그리고 다양한 대화상자(Dialog) 및 선택기(Picker) 활용 방법을 학습하기 위한 프로젝트입니다. 프로젝트는 `app`, `picker`, `pickerdialog` 세 개의 모듈로 구성되어 있으며, Kotlin 언어로 작성되었습니다.

## 2. 주요 학습 내용

### 1) View Binding을 통한 뷰 접근 (모든 모듈)
- `ViewBinding`을 사용하여 안전하고 타입세이프한 방식으로 레이아웃 내의 뷰에 접근합니다.
- `binding = ActivityMainBinding.inflate(layoutInflater)` 방식으로 바인딩 객체를 생성하고, `binding.root`를 통해 루트 뷰를 설정합니다.
- 각 모듈의 `build.gradle.kts`에서 `viewBinding = true` 옵션으로 활성화합니다.

### 2) Activity 전환 및 데이터 전달 (`app` 모듈)
**MainActivity:**
- `Intent`를 사용하여 `MainActivity`에서 `CalcActivity`로 전환합니다.
- 입력받은 두 개의 숫자와 연산자를 Intent의 `putExtra()` 메서드로 데이터를 전달합니다.
- RadioButton의 `checkedRadioButtonId`를 확인하여 선택된 연산자를 식별합니다.

**CalcActivity:**
- `intent.getDoubleExtra()`와 `intent.getStringExtra()`로 전달받은 데이터를 추출합니다.
- When 표현식을 사용한 사칙연산(+, -, *, /) 구현
- 0으로 나누는 경우에 대한 예외 처리

### 3) ActivityResultLauncher를 통한 결과 처리
- `registerForActivityResult()`를 사용하여 `CalcActivity`로부터 반환된 결과를 처리합니다.
- `RESULT_OK`와 `RESULT_CANCELED`를 통해 성공/실패 여부를 판단합니다.
- 결과에 따라 텍스트의 색상을 다르게 표시합니다(성공: 파란색, 실패: 빨간색).

### 4) Picker 위젯 활용 (`picker` 모듈)
- XML 레이아웃에 `DatePicker`와 `TimePicker` 위젯을 직접 포함시켜 화면의 일부로 구성합니다.
- 버튼 클릭 시 `View.VISIBLE`과 `View.INVISIBLE`로 Picker의 표시/숨김을 제어합니다.
- 선택 상태에 따라 버튼의 활성화 여부를 `isEnabled` 속성으로 관리합니다.

### 5) Dialog 형태의 Picker (`pickerdialog` 모듈)
**DatePickerDialog 및 TimePickerDialog:**
- `Calendar.getInstance()`로 현재 날짜/시간을 얻어 Picker의 초기값으로 설정합니다.
- `DatePickerDialog`의 생성자: `(Context, Listener, year, month, day)`
- `TimePickerDialog`의 생성자: `(Context, Listener, hour, minute, is24Hour)`
- 선택된 날짜/시간을 TextView에 표시합니다.

### 6) AlertDialog 구현
**두 가지 방식의 구현:**

**방식 1 - .run { } 블록:**
```kotlin
AlertDialog.Builder(this).run {
    setTitle("알림")
    setMessage("기본 대화상자입니다.")
    setPositiveButton("확인") { _, _ -> ... }
    setNegativeButton("취소") { _, _ -> ... }
    show()
}
```

**방식 2 - 메서드 체이닝:**
```kotlin
val dlg = AlertDialog.Builder(this)
    .setTitle("알림")
    .setMessage("기본 대화상자입니다.")
    .setPositiveButton("확인") { _, _ -> ... }
    .setNegativeButton("취소") { _, _ -> ... }
    .create()
dlg.show()
```

### 7) 최신 안드로이드 디자인 적용
- `enableEdgeToEdge()`를 호출하여 앱의 UI가 시스템 상태 바 및 네비게이션 바 영역까지 확장되도록 설정합니다.
- 최신 Material Design 가이드라인을 준수한 앱 구현 방식을 학습했습니다.

### 8) 이벤트 리스너 등록
- `setOnClickListener()` 메서드로 버튼 클릭 이벤트를 처리합니다.
- Lambda 표현식을 사용한 간결한 이벤트 처리 코드 작성
- 각 모듈에서 버튼 클릭에 따른 화면 전환, Dialog 표시, 데이터 처리 등을 구현합니다.

## 3. 프로젝트 구조 정리

| 모듈 | 주요 기능 | 학습 포인트 |
|------|---------|-----------|
| **app** | 계산기 앱 | Intent 전달, ActivityResultLauncher, 데이터 송수신 |
| **picker** | Picker 위젯 | DatePicker, TimePicker, View 표시/숨김 |
| **pickerdialog** | Dialog 기반 Picker | DatePickerDialog, TimePickerDialog, AlertDialog |

## 4. 요약
오늘은 안드로이드 앱 개발의 **핵심 요소들인 View Binding, Activity 전환, 데이터 전달, 다양한 Dialog 및 Picker 활용**에 대해 집중적으로 학습하였습니다. 특히 다음과 같은 능력을 갖추게 되었습니다:

✓ **UI 구성:** View Binding을 통한 안전한 뷰 접근  
✓ **화면 전환:** Intent를 사용한 Activity 간 전환 및 데이터 전달  
✓ **사용자 입력:** DatePicker, TimePicker, AlertDialog를 활용한 다양한 입력 방식 구현  
✓ **이벤트 처리:** 버튼 클릭과 Dialog 콜백을 통한 동적 화면 업데이트  
✓ **최신 설계:** enableEdgeToEdge를 통한 모던 UI 적용

이러한 학습을 통해 기본적인 안드로이드 앱의 핵심 기능들을 구현할 수 있는 기초를 마련하였습니다.
