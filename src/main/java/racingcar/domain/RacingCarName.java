package racingcar.domain;

import racingcar.constant.ErrorCode;

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
            throw new IllegalArgumentException(ErrorCode.자동차_이름은_5자_이하.getErrorMessage());
        }
        if(racingCarName.length() < MIN_CAR_NAME) {
            throw new IllegalArgumentException(ErrorCode.자동차_이름은_비어있을_수_없음.getErrorMessage());
        }
    }
}
