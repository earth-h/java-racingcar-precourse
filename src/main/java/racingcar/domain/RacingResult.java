package racingcar.domain;

import java.util.List;

public class RacingResult {

    private final List<RacingStatus> racingResult;

    public RacingResult(List<RacingStatus> racingResult) {
        this.racingResult = racingResult;
    }

    public RacingStatus getCurrentRacingResult(int time) {
        return racingResult.get(time);
    }

}
