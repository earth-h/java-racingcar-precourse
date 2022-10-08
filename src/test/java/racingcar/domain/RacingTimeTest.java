package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingTimeTest {

    @ParameterizedTest
    @CsvSource(value = {"-1", "0"}, delimiter = ':')
    void 레이싱_횟수는_양의_정수가_아니면_오류를_반환한다(int count) {
        assertThatThrownBy(() -> {
            new RacingTime(count);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 레이싱을 시도할 횟수는 0보다 큰 양의 정수여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "3", "5"}, delimiter = ':')
    void 레이싱_횟수는_양의_정수여야_한다(int count) {
        RacingTime racingTime = new RacingTime(count);
        assertThat(count).isEqualTo(racingTime.getRacingTime());
    }
}