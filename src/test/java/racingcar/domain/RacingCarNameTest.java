package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RacingCarNameTest {

    @Test
    void 자동차_이름이_6자_이상일_경우_오류_발생() {
        assertThatThrownBy(() -> {
            new RacingCarName("abcdbef");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 자동차_이름이_비어있을_경우_오류_발생() {
        assertThatThrownBy(() -> {
            new RacingCarName("");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 자동차 이름은 비어있을 수 없습니다.");
    }
}
