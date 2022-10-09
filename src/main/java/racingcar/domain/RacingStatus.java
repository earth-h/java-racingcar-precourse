package racingcar.domain;

public enum RacingStatus {

    STOP(""),
    FORWARD("-");

    private final String racingStatusValue;

    RacingStatus(String racingStatusValue) {
        this.racingStatusValue = racingStatusValue;
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
