package racingcar;

public enum RacingStatus {
    STOP,
    FORWARD;

    public static RacingStatus checkStatus(RacingNumber racingNumber) {
        if(racingNumber.isForward()) {
            return RacingStatus.FORWARD;
        }
        return RacingStatus.STOP;
    }
}
