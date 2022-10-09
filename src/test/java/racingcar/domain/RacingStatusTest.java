package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.RacingStatus.getRacingStatusValue;

import org.junit.jupiter.api.Test;

class RacingStatusTest {

    @Test
    void 멈춤일_경우_반환값_테스트() {
        String result = getRacingStatusValue(RacingStatus.STOP);
        assertThat(result).isEqualTo("");
    }

    @Test
    void 전진일_경우_반환값_테스트() {
        String result = getRacingStatusValue(RacingStatus.FORWARD);
        assertThat(result).isEqualTo("-");
    }
}