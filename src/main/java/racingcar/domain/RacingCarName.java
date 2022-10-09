package racingcar.domain;

public class RacingCarName {

    private static final int MAX_CAR_NAME = 5;
    private static final int MIN_CAR_NAME = 1;

    private final String racingCarName;

    public RacingCarName(String racingCarName) {
        validateRacingCarNameLength(racingCarName);
        this.racingCarName = racingCarName;
    }

    private void validateRacingCarNameLength(String racingCarName) {
        if(racingCarName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
        if(racingCarName.length() < MIN_CAR_NAME) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 비어있을 수 없습니다.");
        }
    }
}
