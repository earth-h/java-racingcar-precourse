package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {

    @Test
    void 여러_자동차_경주_1회_결과_출력() {
        List<RacingCar> racingCars = Arrays.asList(
                new RacingCar(new RacingCarName("bob")), new RacingCar(new RacingCarName("cat")));
        List<Integer> racingNumbers = Arrays.asList(9, 0);
        List<String> racingResults = new ArrayList<>();
        for(int index = 0; index < racingCars.size(); index++) {
            racingResults.add(racingCars.get(index).playRacing(new RacingNumber(racingNumbers.get(index))));
        }
        assertThat(racingResults.get(0)).isEqualTo("bob : -");
        assertThat(racingResults.get(1)).isEqualTo("cat : ");
    }

    @Test
    void 여러_자동차_경주_1회_결과_확인() {
        List<RacingCar> racingCars = Arrays.asList(
                new RacingCar(new RacingCarName("bob")), new RacingCar(new RacingCarName("cat")));
        List<Integer> racingNumbers = Arrays.asList(3, 8);
        for(int index = 0; index < racingCars.size(); index++) {
            racingCars.get(index).playRacing(new RacingNumber(racingNumbers.get(index)));
        }
        assertThat(racingCars.get(0).getCurrentLocation().getLocation()).isEqualTo(0);
        assertThat(racingCars.get(1).getCurrentLocation().getLocation()).isEqualTo(1);
    }

    @Test
    void 단일_자동차_경주_2회_결과_출력() {
        RacingCar racingCar = new RacingCar(new RacingCarName("bob"));
        racingCar.playRacing(new RacingNumber(1));
        String racingResult = racingCar.playRacing(new RacingNumber(2));
        assertThat(racingResult).isEqualTo("bob : ");
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "2", "3"})
    void 단일_자동차_경주_1회_결과_멈춤(int number) {
        RacingCar racingCar = new RacingCar(new RacingCarName("bob"));
        racingCar.playRacing(new RacingNumber(number));
        assertThat(racingCar.getCurrentLocation().getLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"})
    void 단일_자동차_경주_1회_결과_전진(int number) {
        RacingCar racingCar = new RacingCar(new RacingCarName("bob"));
        racingCar.playRacing(new RacingNumber(number));
        assertThat(racingCar.getCurrentLocation().getLocation()).isEqualTo(1);
    }

}
