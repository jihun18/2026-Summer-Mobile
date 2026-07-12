# 🍳 만개의 레시피 클론 코딩 프로젝트 (2026 Summer Mobile)

이 프로젝트는 안드로이드 스튜디오를 활용하여 '만개의 레시피' 앱의 주요 기능을 구현한 클론 코딩 프로젝트입니다. 사용자의 냉장고 재료 관리, 레시피 검색, 장보기 메모 등 요리와 관련된 통합 서비스를 제공하는 것을 목표로 합니다.

---

## 🛠 주요 화면별 구현 상세 및 관련 파일

### 1. 메인 인터페이스 & 네비게이션
- **관련 파일**: [MainActivity.kt](file:///app/src/main/java/kr/hnu/ice/project/MainActivity.kt), `activity_main.xml`
- **구현 방법**: 
    - `BottomNavigationView`를 사용하여 5개의 주요 메뉴(홈, 분류, 혜택, 스크랩, MY) 간의 화면 전환을 관리합니다.
    - `FragmentTransaction`의 `replace()` 메서드를 활용하여 `FragmentContainerView` 내의 콘텐츠를 동적으로 교체하는 단일 액티비티 구조로 설계되었습니다.

### 2. 홈 화면 (Home)
- **관련 파일**: [HomeFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/HomeFragment.kt), `fragment_home.xml`
- **구현 방법**:
    - **통합 스크롤**: `NestedScrollView`를 최상위 컨테이너로 사용하여 전체 페이지가 부드럽게 스크롤되도록 구현했습니다.
    - **복합 리스트**: `RecyclerView`와 `LayoutManager`를 조합하여 '최근 본 레시피'(가로), '옥수수 요리'(격자) 등 테마별로 다른 레이아웃을 구성했습니다.
    - **메뉴 토글**: '전체보기' 버튼 클릭 시 `View.GONE`과 `VISIBLE` 속성을 제어하여 추가 퀵 메뉴 아이콘들을 즉각적으로 노출/숨김 처리하는 로직을 포함합니다.

### 3. 검색 화면 (Search)
- **관련 파일**: [SearchFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/SearchFragment.kt), `fragment_search.xml`
- **구현 방법**:
    - **입력 포커스 및 키보드**: 화면 진입 시 `requestFocus()`와 `WindowInsetsControllerCompat` API를 사용하여 시스템 키보드가 자동으로 팝업되도록 사용자 경험을 최적화했습니다.
    - **액션 리스너**: `EditText`의 `setOnEditorActionListener`를 통해 소프트 키보드의 '검색' 아이콘 클릭 이벤트를 감지하여 검색 로직을 수행합니다.

### 4. 냉장고 털기 (Fridge)
- **관련 파일**: [FridgeFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/FridgeFragment.kt), `fragment_fridge.xml`, `item_chip_tag.xml`
- **구현 방법**:
    - **동적 태그 시스템**: `ChipGroup`을 활용하여 입력한 재료를 `Chip` 형태로 실시간 생성합니다. `LayoutInflater`를 통해 커스텀 레이아웃을 인스턴스화하여 추가/삭제 기능을 구현했습니다.
    - **데이터 동기화**: `MutableList`로 선택된 재료 키워드를 관리하며, 검색 버튼 클릭 시 선택된 재료 리스트를 기반으로 레시피 매칭 로직(가상)을 수행합니다.

### 5. 장보기 메모 (Shopping Memo)
- **관련 파일**: [ShoppingMemoFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/ShoppingMemoFragment.kt), `fragment_shopping_memo.xml`
- **구현 방법**:
    - **동적 뷰 팩토리**: XML 레이아웃 대신 `createDynamicRow` 메서드 내에서 `RelativeLayout`, `TextView` 등을 코드로 직접 생성하여 속성을 부여하는 방식을 사용했습니다.
    - **통합 렌더링**: '장보기 목록'과 '구매 완료' 간의 아이템 이동 시 `removeAllViews()` 후 전체 리스트를 다시 그리는 방식으로 데이터 일관성을 유지합니다.
    - **레이아웃 최적화**: 다중 품목 추가 시 겹침 방지를 위해 각 로우의 높이를 `48dp`로 고정했습니다.

### 6. 레시피 상세 (Recipe Detail)
- **관련 파일**: [RecipeDetailFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/RecipeDetailFragment.kt), `fragment_recipe_detail.xml`
- **구현 방법**:
    - **상세 명세 레이아웃**: 조리 과정, 재료 리스트, 추천 상품 등을 포함하는 복합 레이아웃을 구성했습니다.
    - **백스택 제어**: `parentFragmentManager.popBackStack()`을 호출하여 상세 화면에서 이전 목록(홈 또는 스크랩 등)으로 안전하게 되돌아가는 기능을 구현했습니다.

### 7. 스크랩 (Scrap)
- **관련 파일**: [ScrapFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/ScrapFragment.kt), `fragment_scrap.xml`
- **구현 방법**:
    - **커스텀 탭 전환**: `View`의 배경색과 인디케이터 가시성, 텍스트 스타일(`Typeface.BOLD`)을 클릭 이벤트에 따라 동적으로 변경하여 '전체'와 '내폴더' 탭 분기 로직을 구현했습니다.

### 8. MY & 서브 화면 (My Page & Sub Views)
- **관련 파일**: [MyFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/MyFragment.kt), [RecentViewFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/RecentViewFragment.kt), [RecipeRegisterFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/RecipeRegisterFragment.kt)
- **구현 방법**:
    - **화면 흐름(Flow)**: 마이페이지를 중심으로 '최근 본 레시피'와 '레시피 등록' 화면으로의 진입점을 관리합니다.
    - **가상 탭 시스템**: 레시피 등록 화면에서 '공개중/작성중' 상태를 구분하기 위한 커스텀 탭 UI 로직을 구현했습니다.

### 9. 기타 공통 메뉴 (Category & Benefit)
- **관련 파일**: [CategoryFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/CategoryFragment.kt), [BenefitFragment.kt](file:///app/src/main/java/kr/hnu/ice/project/BenefitFragment.kt)
- **구현 방법**:
    - 카테고리별 필터링 UI 및 혜택 카드 레이아웃을 `Fragment` 구조로 설계하여 향후 API 연동을 위한 기반을 마련했습니다.

---

## 📱 기술 스택 및 핵심 라이브러리
- **Language**: Kotlin
- **ViewBinding**: 타입 안정성 확보 및 Null 포인터 예외 방지를 위해 전면 적용.
- **Material Components**: `CardView`, `ChipGroup`, `Button` 등 머티리얼 디자인 가이드라인 준수.
- **Fragment Management**: `replace()`, `addToBackStack()`을 이용한 유기적인 화면 스택 관리.

## 🚀 향후 업데이트 계획
- 실제 서버 API 연동을 통한 데이터 실시간 로딩
- 사용자 프로필 관리 및 쉐프 팔로우 기능 고도화
- 유통기한 임박 재료 푸시 알림 기능
