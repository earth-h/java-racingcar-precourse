package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
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

    public static List<RacingCarName> convertRacingCarNames(String racingCarName) {
        String[] convertCarNames = racingCarName.split(",");
        validateSplitCarName(convertCarNames);
        List<RacingCarName> racingCarNames = new ArrayList<>();
        for(String name: convertCarNames) {
            racingCarNames.add(new RacingCarName(name));
        }
        return racingCarNames;
    }

    private static void validateSplitCarName(String[] convertCarNames) {
        if(convertCarNames.length < 1) {
            throw new IllegalArgumentException(ErrorCode.유효한_자동차_이름_없음.getErrorMessage());
        }
    }
}
