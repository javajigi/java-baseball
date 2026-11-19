package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    void 서로_다른_숫자_3개를_만든다() {
        List<Integer> numbers = new NumberGenerator().generate();

        assertThat(numbers).hasSize(3);
        assertThat(new HashSet<>(numbers)).hasSize(3);
    }

    @Test
    void 모든_숫자는_1부터_9_사이다() {
        List<Integer> numbers = new NumberGenerator().generate();

        assertThat(numbers).allMatch(n -> n >= 1 && n <= 9);
    }
}