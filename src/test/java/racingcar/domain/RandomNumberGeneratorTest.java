package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomNumberGeneratorTest {

    private static final Integer MIN_NUM = 0;
    private static final Integer MAX_NUM = 9;

    @ParameterizedTest
    @CsvSource(value = {"3", "2", "6"}, delimiter = ':')
    void 랜덤_숫자는_모두_9보다_작거나_같음(String racingTime) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> generatedNumber = randomNumberGenerator.generateNumber(new RacingTime(racingTime));
        assertThat(generatedNumber).allMatch(number -> number.compareTo(MAX_NUM) <= 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"3", "2", "6"}, delimiter = ':')
    void 랜덤_숫자는_모두_0보다_크거나_같음(String racingTime) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> generatedNumber = randomNumberGenerator.generateNumber(new RacingTime(racingTime));
        assertThat(generatedNumber).allMatch(number -> number.compareTo(MIN_NUM) >= 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:3", "4:4", "5:5"}, delimiter = ':')
    void 원하는_개수만큼_무작위_숫자_생성(String racingTime, int expectTime) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> generatedNumber = randomNumberGenerator.generateNumber(new RacingTime(racingTime));
        assertThat(generatedNumber.size()).isEqualTo(expectTime);
    }
}