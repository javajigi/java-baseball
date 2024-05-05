# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구 사항
* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의
  수를 맞추면 승리한다.

e.g.
상대방(컴퓨터)의 수가 425일 때,
- 123을 제시한 경우: 1스트라이크
- 456을 제시한 경우: 1볼 1스트라이크
- 789를 제시한 경우: 낫싱

* 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는
  3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 구현한 기능 - Appilcation
* makeNumber 메서드로 유효한 범위의 3자리 숫자를 만든다.
* setNum 메서드로 입력받은 숫자가 유효한 범위인지 확인한다.
* judge 메서드로 입력받은 숫자와 생성된 숫자를 비교해 strike와 ball의 수를 카운트한다.
* print 메서드로 카운트된 strike와 ball의 수에 맞는 결과를 출력한다.
* game 메서드로 1 또는 2를 입력받아 새로운 게임을 할지 종료할지 결정한다.

## 구현한 기능 - test
* testMakeNumber_NoDuplicates 메서드로 만들어진 수가 중복되었는지 테스트한다.
* testMakeNumber_WithinRange 만들어진 수가 1 ~ 9 범위인지 테스트한다.
* testPrint_NoStrikesNoBalls 0 스트라이크 0 볼 일때 출력을 테스트한다.
* testPrint_1Strike0Balls N 스트라이크 0볼 일때 출력을 테스트한다.
* testPrint_0Strikes2Balls0 스트라이크 N 볼 일때 출력을 테스트한다.
* testPrint_2Strikes2Balls N 스트라이크 N 볼 일때 출력을 테스트한다.
* testPrint_3Strikes_GameOver 3 스트라이크로 정답일때 출력을 테스트한다.
* testSetNum_ValidInput 유효한 입력 값에 대해 setNum 메서드가 예외를 던지지 않는지 테스트한다.
* testSetNum_InvalidInput 유효하지 않은 입력 값에 대해 setNum 메서드가 예외를 던지는지 테스트한다.