# JulyFirstApplication

**작성일:** 2026-07-01

이 프로젝트는 Android 기초 학습을 위해 만든 멀티 모듈 실습 저장소입니다.  
각 모듈마다 서로 다른 UI 구성 방식과 Android 핵심 개념을 연습할 수 있도록 구성되어 있습니다.

## 오늘 학습 내용 요약

오늘은 Android 화면 구성, XML 레이아웃, 뷰 속성, 버튼 이벤트, 메뉴 선택, View Binding 사용법을 중심으로 학습했습니다.  
특히 `ActivityMainBinding`이 resolve되지 않는 문제를 확인하면서, `viewBinding` 설정과 레이아웃 파일 이름, 바인딩 import 경로가 올바른지 확인하는 방법도 함께 점검했습니다.

## 모듈별 학습 내용

### 1. `app`
- 기본 Android 앱 구조를 확인하고 View Binding 기반 화면 구성으로 정리했습니다.
- `activity_main.xml`을 통해 `TextView`, `ImageView` 등을 배치하고, `MainActivity`에서 `ActivityMainBinding`으로 접근하도록 구성했습니다.
- XML 레이아웃과 Kotlin 코드가 연결되는 흐름을 이해하는 데 도움이 되는 예제입니다.

### 2. `viewbindingexam`
- View Binding의 핵심 사용법을 실습한 모듈입니다.
- `ActivityMainBinding.inflate(layoutInflater)`로 바인딩 객체를 생성하고, `binding.root`를 통해 화면에 연결합니다.
- `binding.resetBtn`, `binding.changeBtn`, `binding.titleText`처럼 ID 기반으로 뷰에 안전하게 접근하는 방법을 학습했습니다.
- `viewBinding.enable = true` 설정이 반드시 필요하다는 점도 확인했습니다.

### 3. `viewattributes`
- XML에서 뷰 속성을 직접 설정하는 방법을 학습한 모듈입니다.
- `android:text`, `android:textSize`, `android:textStyle`, `android:gravity`, `android:contentDescription` 등 기본 속성을 활용했습니다.
- `enableEdgeToEdge()`와 `WindowInsetsCompat`를 사용해 시스템 바 영역을 고려한 레이아웃 처리도 함께 익혔습니다.

### 4. `xmllayout`
- XML 레이아웃 파일을 사용해 화면을 구성하는 기본 실습 모듈입니다.
- `setContentView(R.layout.activity_main)` 형태로 레이아웃을 연결하는 방식을 익혔습니다.
- Kotlin 코드와 XML 화면이 분리되는 구조를 이해하는 데 초점을 두었습니다.

### 5. `menuselect`
- 메뉴 선택과 관련된 화면 동작을 연습한 모듈입니다.
- 버튼 또는 메뉴 선택에 따라 화면 구성을 다루는 방식과 레이아웃 접근 방식을 학습했습니다.
- `findViewById()`와 `WindowInsetsCompat`를 함께 사용해 기존 View 기반 접근 패턴을 익혔습니다.

### 6. `visibleclick`
- 버튼 클릭 이벤트와 뷰 가시성 제어를 학습한 모듈입니다.
- `VISIBLE`, `INVISIBLE`, `GONE`의 차이를 확인하며 UI 상태 변경을 실습했습니다.
- 클릭 이벤트 처리 흐름과 `findViewById()` 기반의 뷰 제어 방식을 익혔습니다.

## 정리

이번 학습을 통해 아래 내용을 정리할 수 있었습니다.

- XML 레이아웃 파일을 이용한 화면 구성
- `findViewById()`와 View Binding의 차이
- View Binding 설정 방법과 바인딩 클래스 생성 원리
- 버튼 클릭 이벤트 처리
- 뷰의 `VISIBLE`, `INVISIBLE`, `GONE` 상태 차이
- `WindowInsetsCompat`를 활용한 Edge-to-Edge 화면 대응

## 참고

이 저장소는 Android Studio 실습용 프로젝트이며, 모듈별로 독립적인 학습 예제가 포함되어 있습니다.  
추후 필요하면 각 모듈별 실행 방법과 화면 캡처도 추가할 수 있습니다.

