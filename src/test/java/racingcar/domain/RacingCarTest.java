package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.RacingStatus.FORWARD;
import static racingcar.domain.RacingStatus.STOP;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void 단일_자동차의_경주_결과_확인() {
        RacingCar racingCar = new RacingCar(new RacingTime(3),  new ReadLineNumberGenerater("529"), new RacingCarName("bob"));
        List<RacingStatus> racingResult = racingCar.play();
        assertThat(racingResult).isEqualTo(Arrays.asList(FORWARD, STOP, FORWARD));
    }
}
