package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumbersTest {

    @Test
    void 올바른_입력이면_예외가_없다() {
        assertThatCode(() -> new BaseballNumbers("123"))
                .doesNotThrowAnyException();
    }

    @Test
    void 세자리가_아니면_예외() {
        assertThatThrownBy(() -> new BaseballNumbers("12"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_1부터_9_사이가_아니면_예외() {
        assertThatThrownBy(() -> new BaseballNumbers("103"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNumbers("1a3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_숫자가_있으면_예외() {
        assertThatThrownBy(() -> new BaseballNumbers("112"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 모두_같으면_3스트라이크() {
        GameResult result = new BaseballNumbers("123").compare(new BaseballNumbers("123"));

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isThreeStrike()).isTrue();
    }

    @Test
    void 하나도_없으면_낫싱() {
        GameResult result = new BaseballNumbers("123").compare(new BaseballNumbers("456"));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void 숫자는_모두_있지만_자리가_다르면_3볼() {
        GameResult result = new BaseballNumbers("123").compare(new BaseballNumbers("312"));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    void 일스트라이크_일볼() {
        GameResult result = new BaseballNumbers("123").compare(new BaseballNumbers("135"));

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }
}
