package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class ReadLineNumberGenerater implements NumberGenerator{

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    private final List<Integer> generateNumber = new ArrayList<>();
    private final String readNumber;

    public ReadLineNumberGenerater(String readNumber) {
        this.readNumber = readNumber;
    }

    @Override
    public List<Integer> generateNumber(RacingTime racingTime) {
        for(char c: readNumber.toCharArray()) {
            int number = c - '0';
            validateNumberRange(number);
            generateNumber.add(number);
        }
        validateNumberLength(racingTime);
        return generateNumber;
    }

    private void validateNumberLength(RacingTime racingTime) {
        if(generateNumber.size() != racingTime.getRacingTime()) {
            throw new IllegalArgumentException("전진하는 조건 횟수만큼 숫자를 입력하지 않았습니다.");
        }
    }

    private void validateNumberRange(int number) {
        StringBuilder stringBuilder = new StringBuilder().append("[ERROR] 각 차수별 전진하는 조건은 ");
        if(number < MIN_NUM) {
            stringBuilder.append(MIN_NUM).append("보다 작을 수 없습니다.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if(number > MAX_NUM) {
            stringBuilder.append(MAX_NUM).append("보다 클 수 없습니다.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
