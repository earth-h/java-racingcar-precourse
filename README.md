# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현 기능 목록
* 임의의 0에서 9사이 숫자 생성 로직 개발
  * 3 이하일 경우 멈춤, 4 이상일 경우 전진 로직 개발
  * 랜덤 숫자 생성 로직 개발
* 시도할 횟수 입력 받는 로직 개발
  * 횟수가 양의 정수가 아닐 경우, 에러 발생(IllegalArgumentException) -> [ERROR]로 시작하는 에러 메시지 출력
    * 이때, 에러 발생 후 다시 입력할 수 있도록 함
* 경주 대상 자동차 수 입력 받는 로직 개발
  * 각 자동차는 ,(쉼표)로 구분하여 저장
  * 자동차 이름이 6자 이상일 경우 에러 발생(IllegalArgumentException) -> [ERROR]로 시작하는 에러 메시지 출력
    * 이때, 에러 발생 후 다시 입력할 수 있도록 함
* 각 차수별 실행 결과 출력 개발
  * 실행 결과 출력 시, 자동차 이름 함께 출력
  * 전진: - 출력
  * 멈춤: 출력안함
* 우승자 안내 문구 출력 개발
  * 우승자가 두 명 이상일 경우, 쉼표(,)로 구분하여 출력

## TDD 진행
1. 단일 숫자에 대해 3 이하일 경우 멈춤, 4 이상일 경우 전진 로직 테스트 
2. 랜덤 숫자 생성 로직 테스트
  * 랜덤 숫자 범위 테스트 및 생성 개수 테스트
3. 단일 자동차에 대해 시도할 횟수동안의 결과 반환 테스트
  ```java
    // 시도 횟수 받아서 그 횟수만큼 랜덤 수 갖는 RacingCar 객체 생성
    // 실재로는 랜덤 수이지만, 테스트를 위해 ReadLineNumberGenerator 생성해서 직접 값 넣어서 테스트
    RacingCar racingCar = new RacingCar(new RacingTime(int racingTime), new ReadLineNumberGenerater(Arrays.asList(...)), new RacingCarName(string racingCarName)); 
    List<RacingStatus> racingResult = racingCar.play(); // RacingCar 객체의 실행결과를 담은 리스트 반환
  ```
4. 자동차 이름 지정 로직 테스트
  * 자동차 이름이 1~5자 사이인지 테스트
5. 여러 자동차에 대해 시도할 횟수동안의 결과 반환 테스트
  ```java
    List<RacingCarName> racingCarNames = new ArrayList<>(Arrays.asList(new RacingCarName("bob"), new RacingCarName("kebin")));
    List<String> readNumbers = Arrays.asList("135", "249", "021");
    List<RacingCar> racingCars = new ArrayList<>();
    for(int idx = 0; idx < 3; idx++) {
        // 실재로는 랜덤 수이지만, 테스트를 위해 ReadLineNumberGenerator 생성해서 직접 값 넣어서 테스트
        racingCars.add(new RacingCar(new RacingTime(3), new ReadLineNumberGenerater(readNumbers.get(idx)), racingCarNames.get(idx)));
    }
    Map<RacingCarName, RacingResult> racingResults = play(racingCars); // RacingCar 클래스 내 static 메소드로 play 구현
  ```