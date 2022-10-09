package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorCode;

class ReadLineNumberGeneraterTest {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    private final StringBuilder stringBuilder = new StringBuilder();

    @BeforeEach
    void init() {
        stringBuilder.append(ErrorCode.각_차수별_전진하는_조건은.getErrorMessage());
    }

    @Test
    void 입력받은_숫자_개수가_racingTime과_다르면_오류_발생() {
        ReadLineNumberGenerater readLineNumberGenerater = new ReadLineNumberGenerater("035");
        assertThatThrownBy(() -> {
            readLineNumberGenerater.generateNumber(new RacingTime(2));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.RACING_TIME만큼_숫자를_입력하지_않음.getErrorMessage());
    }

    @Test
    void 입력받은_숫자_중_9보다_큰_수가_있으면_오류_발생() {
        ReadLineNumberGenerater readLineNumberGenerater = new ReadLineNumberGenerater("0A");
        stringBuilder.append(MAX_NUM).append(ErrorCode.보다_클_수_없음.getErrorMessage());
        assertThatThrownBy(() -> {
            readLineNumberGenerater.generateNumber(new RacingTime(2));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(stringBuilder.toString());
    }

    @Test
    void 입력받은_숫자_중_0보다_작은_수가_있으면_오류_발생() {
        ReadLineNumberGenerater readLineNumberGenerater = new ReadLineNumberGenerater("0,2");
        stringBuilder.append(MIN_NUM).append(ErrorCode.보다_작을_수_없음.getErrorMessage());
        assertThatThrownBy(() -> {
            readLineNumberGenerater.generateNumber(new RacingTime(3));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(stringBuilder.toString());
    }
}