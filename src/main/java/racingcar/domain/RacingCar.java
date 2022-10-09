package racingcar.domain;

import static racingcar.domain.RacingNumber.convertToRacingNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.constant.ErrorCode;

public class RacingCar {

    private final List<RacingNumber> racingNumbers;
    private final RacingCarName racingCarName;

    public RacingCar(RacingTime racingTime, NumberGenerator numberGenerator, RacingCarName racingCarName) {
        racingNumbers = convertToRacingNumber(numberGenerator.generateNumber(racingTime));
        validateRacingNumbersLength(racingTime);
        this.racingCarName = racingCarName;
    }

    private void validateRacingNumbersLength(RacingTime racingTime) {
        if(racingNumbers.size() != racingTime.getRacingTime()) {
            throw new IllegalArgumentException(ErrorCode.RACING_TIME만큼_숫자가_생성되지_않음.getErrorMessage());
        }
    }

    public RacingResult play() {
        List<RacingStatus> racingStatusList = new ArrayList<>();
        for(RacingNumber racingNumber: racingNumbers) {
            racingStatusList.add(RacingStatus.checkStatus(racingNumber));
        }
        return new RacingResult(racingStatusList);
    }

    public static Map<RacingCarName, RacingResult> playRacingGame(List<RacingCar> racingCars) {
        Map<RacingCarName, RacingResult> racingResults = new HashMap<>();
        for(RacingCar racingCar: racingCars) {
            racingResults.put(racingCar.racingCarName, racingCar.play());
        }
        return racingResults;
    }
}
