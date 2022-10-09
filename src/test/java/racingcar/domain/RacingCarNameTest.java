package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorCode;

public class RacingCarNameTest {

    @Test
    void 자동차_이름이_6자_이상일_경우_오류_발생() {
        assertThatThrownBy(() -> {
            new RacingCarName("abcdbef");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.자동차_이름은_5자_이하.getErrorMessage());
    }

    @Test
    void 자동차_이름이_비어있을_경우_오류_발생() {
        assertThatThrownBy(() -> {
            new RacingCarName("");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorCode.자동차_이름은_비어있을_수_없음.getErrorMessage());
    }
}
