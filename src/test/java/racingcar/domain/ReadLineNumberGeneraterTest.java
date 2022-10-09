package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReadLineNumberGeneraterTest {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    private final StringBuilder stringBuilder = new StringBuilder();

    @BeforeEach
    void init() {
        stringBuilder.append("[ERROR] 각 차수별 전진하는 조건은 ");
    }

    @Test
    void 입력받은_숫자_개수가_racingTime과_다르면_오류_발생() {
        ReadLineNumberGenerater readLineNumberGenerater = new ReadLineNumberGenerater("035");
        assertThatThrownBy(() -> {
            readLineNumberGenerater.generateNumber(new RacingTime(2));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("전진하는 조건 횟수만큼 숫자를 입력하지 않았습니다.");
    }

    @Test
    void 입력받은_숫자_중_9보다_큰_수가_있으면_오류_발생() {
        ReadLineNumberGenerater readLineNumberGenerater = new ReadLineNumberGenerater("0A");
        stringBuilder.append(MAX_NUM).append("보다 클 수 없습니다.");
        assertThatThrownBy(() -> {
            readLineNumberGenerater.generateNumber(new RacingTime(2));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(stringBuilder.toString());
    }

    @Test
    void 입력받은_숫자_중_0보다_작은_수가_있으면_오류_발생() {
        ReadLineNumberGenerater readLineNumberGenerater = new ReadLineNumberGenerater("0,2");
        stringBuilder.append(MIN_NUM).append("보다 작을 수 없습니다.");
        assertThatThrownBy(() -> {
            readLineNumberGenerater.generateNumber(new RacingTime(3));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(stringBuilder.toString());
    }
}