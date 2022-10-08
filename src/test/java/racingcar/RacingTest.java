package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"}, delimiter = ':')
    void 숫자가_4_이상_9_이하일_경우_멈춤(int racingNumber) {
        assertThat(RacingStatus.checkStatus(new RacingNumber(racingNumber))).isEqualTo(RacingStatus.FORWARD);
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "2", "3"}, delimiter = ':')
    void 숫자가_3_이하일_경우_멈춤(int racingNumber) {
        assertThat(RacingStatus.checkStatus(new RacingNumber(racingNumber))).isEqualTo(RacingStatus.STOP);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "10", "-2", "13"}, delimiter = ':')
    void 숫자가_0보다_작거나_9보다_클_경우_오류_발생(int racingNumber) {
        assertThatThrownBy(() -> {
            RacingStatus.checkStatus(new RacingNumber(racingNumber));
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 전진하는 조건은 0과 9 사이의 값이어야 합니다.");
    }
}
