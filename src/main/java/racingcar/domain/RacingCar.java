package racingcar.domain;

import static racingcar.domain.RacingNumber.convertToRacingNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            throw new IllegalArgumentException("전진하는 조건 횟수만큼 숫자가 생성되지 않았습니다.");
        }
    }

    public List<RacingStatus> play() {
        List<RacingStatus> racingStatusList = new ArrayList<>();
        for(RacingNumber racingNumber: racingNumbers) {
            racingStatusList.add(RacingStatus.checkStatus(racingNumber));
        }
        return racingStatusList;
    }

    public static Map<RacingCarName, RacingResult> play(List<RacingCar> racingCars) {
        Map<RacingCarName, RacingResult> racingResults = new HashMap<>();
        for(RacingCar racingCar: racingCars) {
            racingResults.put(racingCar.racingCarName, new RacingResult(racingCar.play()));
        }
        return racingResults;
    }
}
