package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.RacingCar.playRacingGame;
import static racingcar.domain.RacingStatus.FORWARD;
import static racingcar.domain.RacingStatus.STOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void 여러_자동차의_경주_결과_확인() {
        List<RacingCarName> racingCarNames = new ArrayList<>(Arrays.asList(new RacingCarName("bob"), new RacingCarName("kebin"), new RacingCarName("hi")));
        List<String> readNumbers = Arrays.asList("135", "021", "875");
        List<RacingCar> racingCars = new ArrayList<>();
        for(int idx = 0; idx < 3; idx++) {
            racingCars.add(new RacingCar(new RacingTime(3), new ReadLineNumberGenerater(readNumbers.get(idx)), racingCarNames.get(idx)));
        }
        Map<RacingCarName, RacingResult> racingResults = playRacingGame(racingCars);
        assertThat(racingResults.get(racingCarNames.get(0))).usingRecursiveComparison().isEqualTo(new RacingResult(Arrays.asList(STOP, STOP, FORWARD)));
        assertThat(racingResults.get(racingCarNames.get(1))).usingRecursiveComparison().isEqualTo(new RacingResult(Arrays.asList(STOP, STOP, STOP)));
        assertThat(racingResults.get(racingCarNames.get(2))).usingRecursiveComparison().isEqualTo(new RacingResult(Arrays.asList(FORWARD, FORWARD, FORWARD)));
    }

    @Test
    void 단일_자동차의_경주_결과_확인() {
        RacingCar racingCar = new RacingCar(new RacingTime(3),  new ReadLineNumberGenerater("529"), new RacingCarName("bob"));
        RacingResult racingResult = racingCar.play();
        assertThat(racingResult).usingRecursiveComparison().isEqualTo(new RacingResult(Arrays.asList(FORWARD, STOP, FORWARD)));
    }
}
