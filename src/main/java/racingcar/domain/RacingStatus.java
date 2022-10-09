package racingcar.domain;

public enum RacingStatus {

    STOP(""),
    FORWARD("-");

    private final String racingStatusValue;

    RacingStatus(String racingStatusValue) {
        this.racingStatusValue = racingStatusValue;
    }

    public boolean isForward() {
        return this == FORWARD;
    }

    public static String printRacingStatus(RacingCarLocation racingCarLocation) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int cnt = 0; cnt < racingCarLocation.getLocation(); cnt++) {
            stringBuilder.append(FORWARD.racingStatusValue);
        }
        return stringBuilder.toString();
    }

    public static RacingStatus checkStatus(RacingNumber racingNumber) {
        if(racingNumber.isForward()) {
            return RacingStatus.FORWARD;
        }
        return RacingStatus.STOP;
    }

    public static String getRacingStatusValue(RacingStatus racingStatus) {
        return racingStatus.racingStatusValue;
    }

}
