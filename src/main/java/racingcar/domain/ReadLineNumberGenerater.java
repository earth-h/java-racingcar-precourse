package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ErrorCode;

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
            throw new IllegalArgumentException(ErrorCode.RACING_TIME만큼_숫자를_입력하지_않음.getErrorMessage());
        }
    }

    private void validateNumberRange(int number) {
        StringBuilder stringBuilder = new StringBuilder().append(ErrorCode.각_차수별_전진하는_조건은.getErrorMessage());
        if(number < MIN_NUM) {
            stringBuilder.append(MIN_NUM).append(ErrorCode.보다_작을_수_없음.getErrorMessage());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if(number > MAX_NUM) {
            stringBuilder.append(MAX_NUM).append(ErrorCode.보다_클_수_없음.getErrorMessage());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
