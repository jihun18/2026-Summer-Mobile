# July07Application

작성일: 2026년 07월 07일

## 프로젝트 소개

`July07Application`은 Android에서 **4개의 Activity를 서로 전환**해 보며, 화면 이동의 기본 개념을 학습한 예제 프로젝트입니다.

이 프로젝트를 통해 다음 내용을 연습했습니다.

- `Activity` 간 화면 전환
- `Intent`를 사용한 화면 이동
- `View Binding`을 이용한 안전한 뷰 접근
- `finish()`를 이용한 현재 화면 종료
- `Toast`로 사용자 피드백 표시
- `AndroidManifest.xml`을 통한 Activity 등록 및 launcher 설정
- `ConstraintLayout`과 `LinearLayout`을 활용한 간단한 UI 구성

## 사용 기술

- **언어**: Kotlin
- **UI 구성**: XML 레이아웃
- **바인딩**: View Binding
- **기본 컴포넌트**: AppCompatActivity, Intent, Toast
- **레이아웃**: ConstraintLayout, LinearLayout
- **테마**: Material3 DayNight NoActionBar

## 화면 구성

### 1. MainActivity
- 앱의 시작 화면입니다.
- `두 번째 화면`, `세 번째 화면`, `네 번째 화면`으로 이동할 수 있습니다.
- `SecondActivity`로 이동할 때는 `where`, `value` 값을 `Intent extra`로 전달합니다.

### 2. SecondActivity
- 종료 버튼과 다른 화면 이동 버튼이 있는 화면입니다.
- `종료` 버튼을 누르면 `Toast`를 띄운 뒤 현재 화면을 닫습니다.
- `세 번째 화면`, `네 번째 화면`으로 이동할 수 있습니다.

### 3. ThirdActivity
- 종료 버튼과 화면 이동 버튼이 있는 화면입니다.
- `종료` 버튼을 누르면 `Toast`를 띄운 뒤 현재 화면을 닫습니다.
- `첫 번째 화면`, `네 번째 화면`으로 이동할 수 있습니다.

### 4. ForthActivity
- 종료 버튼과 화면 이동 버튼이 있는 화면입니다.
- `종료` 버튼을 누르면 `Toast`를 띄운 뒤 현재 화면을 닫습니다.
- `첫 번째 화면`, `두 번째 화면`으로 이동할 수 있습니다.

## 화면 전환 흐름

| 현재 화면 | 이동 가능 화면 |
| --- | --- |
| MainActivity | SecondActivity, ThirdActivity, ForthActivity |
| SecondActivity | ThirdActivity, ForthActivity |
| ThirdActivity | MainActivity, ForthActivity |
| ForthActivity | MainActivity, SecondActivity |

## 학습하면서 이해한 핵심 내용

### 1. Activity 전환의 기본 구조
- 한 화면을 `Activity`로 만들고, 버튼 클릭 시 `Intent`를 통해 다른 `Activity`를 실행하는 방식을 익혔습니다.
- Android 앱에서 가장 기본이 되는 화면 전환 흐름을 직접 구현했습니다.

### 2. View Binding 사용
- `findViewById()` 대신 `ActivityMainBinding`, `ActivitySecondBinding` 같은 바인딩 클래스를 사용했습니다.
- 이를 통해 코드가 더 안전하고 읽기 쉬워졌습니다.

### 3. Intent Extra 전달
- `MainActivity`에서 `SecondActivity`로 이동할 때 `where`, `value` 값을 전달했습니다.
- 화면 간 데이터 전달의 기본 방식을 학습했습니다.

### 4. 화면 종료 처리
- `finish()`를 사용하여 현재 화면만 닫는 동작을 구현했습니다.
- 단순 이동과 종료를 구분해 다루는 방법을 익혔습니다.

### 5. AndroidManifest 역할 이해
- 각 Activity를 Manifest에 등록하고, `MainActivity`를 launcher로 설정했습니다.
- 앱 시작 진입점과 화면 선언 방식도 함께 확인했습니다.

### 6. XML 레이아웃 구성
- 각 화면을 XML로 작성하고, 버튼과 텍스트를 배치했습니다.
- `ConstraintLayout`과 `LinearLayout`을 함께 사용하며 간단한 UI 구조를 연습했습니다.

## 프로젝트 구조

```text
app/src/main/
├── AndroidManifest.xml
├── java/kr/hnu/ice/july07application/
│   ├── MainActivity.kt
│   ├── SecondActivity.kt
│   ├── ThirdActivity.kt
│   └── ForthActivity.kt
└── res/
    ├── layout/
    │   ├── activity_main.xml
    │   ├── activity_second.xml
    │   ├── activity_third.xml
    │   └── activity_forth.xml
    └── values/
        ├── strings.xml
        └── themes.xml
```

## 정리

이번 `July07Application` 프로젝트에서는 Android 앱의 가장 기본적인 요소인 **화면 구성, Activity 전환, Intent 전달, View Binding, 종료 처리**를 집중적으로 학습했습니다.

특히 여러 화면을 왔다 갔다 하면서, 앱의 화면 흐름이 어떻게 구성되는지 직접 확인할 수 있었고, Android 프로젝트의 전체 구조도 함께 익힐 수 있었습니다.

