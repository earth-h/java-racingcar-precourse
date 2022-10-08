package racingcar;

/**
 * Racing 시 사용할 숫자값 Wrapping 클래스
 */
public class RacingNumber {

    private static final int MIN_FORWARD = 4;
    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;

    private final int racingNumber;

    public RacingNumber(int racingNumber) {
        validateRacingNumber(racingNumber);
        this.racingNumber = racingNumber;
    }

    private void validateRacingNumber(int racingNumber) {
        if(racingNumber < MIN_NUM || racingNumber > MAX_NUM) {
            throw new IllegalArgumentException("[ERROR] 전진하는 조건은 0과 9 사이의 값이어야 합니다.");
        }
    }

    public boolean isForward() {
        return this.racingNumber >= MIN_FORWARD;
    }
}
