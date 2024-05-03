# :baseball: 숫자 야구 게임

<strong>간단한 숫자 야구 게임을 즐겨보세요.</strong>

코틀린 기본 문법을 공부한 뒤 응용해서 만들어 본 과제입니다.

<br/>

## :books: 프로젝트 필수 구현 사항

#### 필수 구현 기능

- 요구사항별로 상세 기능을 생각해요 / 사용하면서 발생할 수 있는 예외사항들을 고려해봅니다.
  - 입력과 출력
    - 입력
        - 서로 다른 3자리 수
        - 게임 시작, 기록 보기, 종료를 구분하는 수 입력
            - 필수 구현에서는 실행 시, 바로 게임 시작
            - 선택 구현에서 시작, 기록, 종료 구분
    - 출력
        - 입력한 수에 대한 결과값을 “볼, 스트라이크, Nothing”으로 표시
- 요구사항
    - 1에서 9까지의 서로 다른 임의의 수 3개를 정하고 맞추는 게임입니다
    - 정답은 랜덤으로 만듭니다.(1에서 9까지의 서로 다른 임의의 수 3자리)
    - 상세
        - 정답을 맞추기 위해 3자리수를 입력하고 힌트를 받습니다
            - 힌트는 야구용어인 **볼**과 **스트라이크**입니다.
            - 같은 자리에 같은 숫자가 있는 경우 **스트라이크**, 다른 자리에 숫자가 있는 경우 **볼**입니다.
                - ex) 정답 : 456 인 경우
                    - 435를 입력한 경우 → 1스트라이크 1볼
                    - 357를 입력한 경우 → 1스트라이크
                    - 678를 입력한 경우 → 1볼
                    - 123를 입력한 경우 → Nothing
            - 만약 올바르지 않은 입력값에 대해서는 오류 문구를 보여주세요.
            - 3자리 숫자가 정답과 같은 경우 게임이 종료됩니다.
     
#### 선택 구현 기능

- 1번
  - 프로그램을 시작할 때 안내문구를 보여주세요.
  - 1번 게임 시작하기의 경우 “필수 구현 기능” 의 예시처럼 게임이 진행됩니다
  - 정답을 맞혀 게임이 종료된 경우 위 안내문구를 다시 보여주세요
    
    <pre><code>// 예시
    환영합니다! 원하시는 번호를 입력해주세요
    1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기
    1 // 1번 게임 시작하기 입력

    < 게임을 시작합니다 >
    숫자를 입력하세요
    .
    .
    .
    ​
    </code></pre>

- 2번
  - 정답이 되는 숫자를 0에서 9까지의 서로 다른 3자리의 숫자로 바꿔주세요
  - 맨 앞자리에 0이 오는 것은 불가능합니다
    - 092 → 불가능
    - 870 → 가능
    - 300 → 불가능
- 3번
  - 실행 시, 2번 게임 기록 보기의 경우 완료한 게임들에 대해 시도 횟수를 보여줍니다.
    <pre><code>// 예시
    환영합니다! 원하시는 번호를 입력해주세요
    1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기
    2 // 2번 게임 기록 보기 입력
      
    < 게임 기록 보기 >
    1번째 게임 : 시도 횟수 - 14
    2번째 게임 : 시도 횟수 - 9
    3번째 게임 : 시도 횟수 - 12
    .
    .
    .
    
    </code></pre>

- 4번
  - 실행 시, 3번 종료하기의 경우 프로그램이 종료됩니다.
  - 이전의 게임 기록들도 초기화됩니다.
    <pre><code>// 예시
    환영합니다! 원하시는 번호를 입력해주세요
    1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기
    3 // 3번 종료하기 입력
    
    < 숫자 야구 게임을 종료합니다 >
    ​
    1, 2, 3 이외의 입력값에 대해서는 오류 메시지를 보여주세요
    // 예시
    환영합니다! 원하시는 번호를 입력해주세요
    1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기
    4 // 잘못된 숫자 입력
    
    올바른 숫자를 입력해주세요!</code></pre>

<br/>

## :clipboard: 프로젝트 필수, 선택 구현사항에 따라 제작한 야구 게임 세부사항
- ver_1, ver_2, ver_3 총 3가지 버전이 있습니다. 하나로 합치는 것도 가능하지만 전체 코드 작성 과정을 남겨놓고 싶어서 3가지 버전 모두 남겨놓았습니다.
- ver_1은 필수 구현사항(일부 선택 구현사항)에 따라, ver_2는 선택 구현사항에 따라 만들었습니다.
- ver_1에서는 필수 구현기능을 모두 구현하여 야구 게임을 만들어보았습니다. 선택 구현기능 1번(시작 메뉴)과 3번(게임 기록 저장), 4번(게임 종료, 예외처리)도 구현되어 있습니다.
- ver_2에서는 선택구현 2번(0을 포함한 게임)을 구현하였습니다. 아예 0을 포함한 게임과, 0을 포함하지 않은 게임을 따로 분리하여 만들어 보았습니다.

<br/>

## :beer: 개인적으로 추가해본 야구 게임 기능들
- ver_3에서는 객체지향 프로그래밍을 조금 더 활용해보고 싶어 0을 포함한 게임은 없애고, 다른 야구 게임을 2개 더 추가하였습니다.
- Easy 모드, 일반 모드, Hard 모드 3가지 야구 게임을 플레이 할 수 있습니다.
- 모두 같은 야구 게임이지만 Easy 모드는 숫자를 1\~7까지만 활용하고, 일반 모드에서는 1\~9까지 활용합니다. Hard 모드는 숫자 대신 소문자 알파벳 a~z 26글자를 활용합니다.
- 모두 같은 야구 게임이기 때문에 공통으로 사용하는 함수와 변수들이 많아 그것들을 추상 클래스(AbstractBaseballGame)에 넣어주고 이것을 상속받아 게임을 구현하도록 만들었습니다.
- 게임 타입(일반 모드인지, Easy 모드인지, Hard 모드인지)은 추상 속성으로 반드시 상속받아 초기화 시켜주어야 합니다. 실제 게임 동작 함수 역시 추상 메서드로 되어있고 상속받아서 반드시 구현해야합니다.
- 또 다른 야구 게임이 추가되더라도 코드 변경을 많이 하지 않아도 되도록 최대한 노력해보았습니다.

<br/>

## :pushpin: 환경설정
- Language: Kotlin
- IDE: Intellij
- SDK: Eclipse Temurin 18.0.2
