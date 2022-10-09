package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

/**
 * 무작위(random) 숫자 생성기
 */
public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    private final List<Integer> generateNumber = new ArrayList<>();

    @Override
    public List<Integer> generateNumber(RacingTime racingTime) {
        while(checkCompleteGenerateNumber(racingTime.getRacingTime())) {
            int number = pickNumberInRange(MIN_NUM, MAX_NUM);
            generateNumber.add(number);
        }
        return generateNumber;
    }

    private boolean checkCompleteGenerateNumber(int racingTime) {
        return generateNumber.size() < racingTime;
    }
}
