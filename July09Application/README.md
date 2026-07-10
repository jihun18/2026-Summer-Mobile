# July09Application

날짜: 2026-07-09

요약
- 이 프로젝트는 Android의 주요 UI 컴포넌트(툴바/메뉴, Fragment 교체, Drawer, RecyclerView, ViewPager2)를 실습하기 위해 여러 모듈로 구성된 예제 모음입니다. 각 모듈은 독립적으로 실행 가능한 샘플 앱 형태로 구성되어 있으며, ViewBinding과 Gradle의 버전 카탈로그(libs.versions.toml)를 사용합니다.

학습 내용 (모듈별 요약)

- app
  - 목적: 기본 Activity에서 툴바와 동적 메뉴(옵션메뉴 + SearchView)의 동작을 실습.
  - 핵심 포인트: enableEdgeToEdge(), setSupportActionBar() 사용, 동적 메뉴 추가 및 SearchView 쿼리/변경 리스너로 UI 반응 처리.

- fragmentapp
  - 목적: 버튼으로 프래그먼트를 교체하는 기본 Fragment 사용법을 실습.
  - 핵심 포인트: supportFragmentManager.beginTransaction().replace(...).commit()으로 프래그먼트 전환, ViewBinding 사용, 버튼으로 현재 프래그먼트 토글 제어.

- mydrawer
  - 목적: Drawer 레이아웃 및 엣지-투-엣지(edge-to-edge) 처리 관련 실습.
  - 핵심 포인트: enableEdgeToEdge() 호출로 시스템 바/네비게이션과의 레이아웃 처리, 바인딩으로 레이아웃 초기화.

- recyclerview
  - 목적: RecyclerView를 이용한 리스트 표시와 항목 추가/삭제 구현을 실습.
  - 핵심 포인트: LinearLayoutManager와 어댑터 연결, 데이터 변경 시 notifyItemInserted/notifyItemRemoved 호출, 항목 클릭 이벤트 처리(토스트 등).

- viewpager
  - 목적: ViewPager2와 FragmentStateAdapter를 이용한 페이지 전환 구현 예제.
  - 핵심 포인트: FragmentStateAdapter 상속으로 고정 또는 동적 페이지 제공, Activity에서 viewPager.adapter 설정으로 페이지 전환 테스트.

빌드/실행
- Android Studio에서 프로젝트 루트(C:\Users\User\AndroidStudioProjects\2026-IPP\July09Application)를 열고 모듈 중 실행할 모듈을 Run 구성으로 선택하여 빌드/실행하세요.
- 명령어(Windows PowerShell 예):

  ./gradlew :app:assembleDebug

  또는 특정 모듈 예: ./gradlew :recyclerview:assembleDebug

주요 파일/설정 메모
- `settings.gradle.kts`: 프로젝트에 포함된 모듈(`:app`, `:fragmentapp`, `:recyclerview`, `:viewpager`, `:mydrawer`)을 선언합니다.
- 루트/모듈 `build.gradle.kts`: libs 버전 카탈로그를 통한 의존성 관리, 각 모듈에서 `viewBinding`이 활성화되어 있음.
- 패키지 네임스페이스: 각 모듈은 `kr.hnu.ice.*` 네임스페이스를 사용합니다.

추가 팁
- 각 모듈의 MainActivity와 Fragment/Adapter 소스 파일을 직접 열어서 ViewBinding 사용 방식과 라이프사이클 처리, 리스너 구현 방식을 살펴보세요. 실습을 통해 RecyclerView 어댑터의 데이터 변경 통지와 Fragment 전환 시의 상태 관리를 학습하기에 적합합니다.

끝.

