# July06Application 학습 정리

**학습 날짜:** 2026년 7월 6일

## 오늘의 학습 내용

오늘은 Android 기본 화면 구성과 UI 상태 제어를 중심으로 학습했다.  
단일 Activity 구조에서 `ViewBinding`을 활용해 XML 화면 요소를 안전하게 연결하고, `Chronometer`를 시작/중지/초기화하는 기능을 구현했다. 또한 뒤로가기 동작을 커스터마이징하여 앱 종료를 제어하는 방법을 익혔다.

## 핵심 포인트

- **ViewBinding 사용**
  - `ActivityMainBinding`으로 레이아웃 요소를 직접 참조
  - `findViewById()` 없이 안전하게 UI 접근

- **Chronometer 제어**
  - 시작 버튼으로 타이머 시작
  - 정지 버튼으로 일시 정지
  - 초기화 버튼으로 값 리셋

- **버튼 상태 전환**
  - 현재 실행 상태에 따라 버튼 활성/비활성 처리
  - 사용자 조작 흐름을 자연스럽게 구성

- **뒤로가기 동작 처리**
  - `onBackPressedDispatcher`를 사용해 기본 종료 동작을 변경
  - 일정 시간 안에 두 번 뒤로가기를 눌러야 종료되는 방식 학습

- **화면 방향별 레이아웃 분기**
  - 세로 화면용 `activity_main.xml`
  - 가로 화면용 `layout-land/activity_main.xml`
  - 방향 전환에 따른 UI 재배치 방법 학습

## 확인한 주요 파일

- `app/src/main/java/kr/hnu/ice/july06application/MainActivity.kt`
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/res/layout-land/activity_main.xml`
- `app/build.gradle.kts`

## 학습 결과

이번 실습을 통해 Android 앱에서

1. 화면 바인딩 방법을 익히고,
2. 타이머 기반 UI를 제어하고,
3. 사용자 입력에 따라 버튼 상태와 종료 흐름을 관리하는 방법을 학습했다.

---


