package racingcar.domain;

import static racingcar.domain.RacingStatus.printRacingStatus;

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
        StringBuilder stringBuilder = new StringBuilder().append(racingCarName.getRacingCarName()).append(PRINT_CURRENT_RACING_LOCATION);
        stringBuilder.append(printRacingStatus(racingCarLocation));
        return stringBuilder.toString();
    }
}
