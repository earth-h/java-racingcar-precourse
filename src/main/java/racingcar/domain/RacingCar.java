package racingcar.domain;

import static racingcar.domain.RacingStatus.printRacingStatus;
import static racingcar.utils.StringUtils.convertListToString;

import java.util.Arrays;
import java.util.List;

public class RacingCar {

    private static final String PRINT_CURRENT_RACING_LOCATION = " : ";

    private final RacingCarName racingCarName;
    private final RacingCarLocation racingCarLocation;

    public RacingCar(RacingCarName racingCarName) {
        this.racingCarName = racingCarName;
        this.racingCarLocation = new RacingCarLocation();
    }

    public RacingCarLocation getCurrentLocation() {
        return racingCarLocation;
    }

    public String playRacing(RacingNumber racingNumber) {
        this.racingCarLocation.updateLocation(RacingStatus.checkStatus(racingNumber));
        return printCurrentRacingLocation();
    }

    public String printCurrentRacingLocation() {
        List<String> currentRacingLocation = Arrays.asList(racingCarName.getRacingCarName(),
                printRacingStatus(racingCarLocation));
        return convertListToString(currentRacingLocation, PRINT_CURRENT_RACING_LOCATION);
    }
}
