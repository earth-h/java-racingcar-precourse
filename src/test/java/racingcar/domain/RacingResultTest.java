package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.RacingStatus.MOVING_FORWARD;
import static racingcar.domain.RacingStatus.STOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingResultTest {

    @Test
    void 경기_결과_변경을_막기_위해_특정_시점_결과만_가져옴() {
        RacingResult racingResult = new RacingResult(Arrays.asList(MOVING_FORWARD, STOP));
        assertThat(racingResult.getCurrentRacingResult(0)).isEqualTo(MOVING_FORWARD);
        assertThat(racingResult.getCurrentRacingResult(1)).isEqualTo(STOP);
    }

    @Test
    void final도_값_변경이_가능함() {
        final List<String> racingResult = new ArrayList<>();
        racingResult.add("STOP");
        assertThat(racingResult.size()).isEqualTo(1);
    }
}