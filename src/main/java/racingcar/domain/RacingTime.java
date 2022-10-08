package racingcar.domain;

/**
 * 레이싱을 진행할 횟수
 */
public class RacingTime {

    private final int racingTime;

    public RacingTime(int racingTime) {
        validateRacingTime(racingTime);
        this.racingTime = racingTime;
    }

    private void validateRacingTime(int racingTime) {
        if(racingTime < 1) {
            throw new IllegalArgumentException("[ERROR] 레이싱을 시도할 횟수는 0보다 큰 양의 정수여야 합니다.");
        }
    }

    public int getRacingTime() {
        return racingTime;
    }
}
