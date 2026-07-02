# July02Application

작성일: 2026-07-02

요약
--
이 리포지토리는 여러 개의 Android 예제/연습 모듈을 포함하는 멀티모듈 프로젝트입니다. 오늘(2026-07-02)은 각 모듈 구조를 검토하고 `phonepad` 모듈의 숫자패드 레이아웃을 숫자형 원형 버튼 스타일로 수정하고 영상통화 / 통화 / 삭제 버튼을 추가하는 작업을 수행했습니다. 아래에 모듈별 학습 내용을 정리합니다.

모듈별 학습 내용
--

- app
  - 위치: `app/`
  - 설명: 메인 애플리케이션 모듈입니다. 간단한 LinearLayout 기반 UI와 여러 버튼이 포함되어 있으며 app 레벨의 설정(build.gradle.kts)에서 네임스페이스와 빌드 구성이 정의되어 있습니다.
  - 참고 파일: `app/src/main/res/layout/activity_main.xml`, `app/build.gradle.kts`

- dogcatshow
  - 위치: `dogcatshow/`
  - 설명: 개/고양이 이미지 토글 데모입니다. FrameLayout 내 ImageView와 버튼으로 동작을 전환하는 간단한 예제입니다.
  - 참고 파일: `dogcatshow/src/main/res/layout/activity_main.xml`, `dogcatshow/build.gradle.kts`

- gravityexam
  - 위치: `gravityexam/`
  - 설명: Gravity(정렬 속성)를 보여주는 예제 레이아웃으로, 중앙 정렬된 TextView 등 레이아웃 속성 학습용 파일이 포함되어 있습니다.
  - 참고 파일: `gravityexam/src/main/res/layout/activity_main.xml`

- phonepad
  - 위치: `phonepad/`
  - 설명: 전화기 숫자패드 예제 모듈입니다. 오늘 레이아웃을 숫자패드 형식으로 바꾸고 각 버튼을 둥근(원형) 스타일로 적용했습니다. 또한 영상통화(파랑), 0(흰색), 숫자삭제(빨강) 버튼과 하단의 큰 통화 버튼(녹색)을 추가했습니다.
  - 변경 사항 요약:
    - `phonepad/src/main/res/layout/activity_main.xml`를 숫자패드(1~9, 0) 및 기능 버튼(영상통화, 삭제, 통화)으로 수정
    - 둥근 버튼을 위한 drawable 추가: `phonepad/src/main/res/drawable/circle_button.xml`, `circle_call.xml`, `circle_video.xml`, `circle_delete.xml`
  - 참고 파일: 위 경로들

- relativeexam
  - 위치: `relativeexam/`
  - 설명: RelativeLayout 사용 예제로 여러 TextView를 상대위치로 배치한 예제 파일이 포함되어 있습니다.
  - 참고 파일: `relativeexam/src/main/res/layout/activity_main.xml`

