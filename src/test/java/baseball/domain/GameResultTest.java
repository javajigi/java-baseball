package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    void 스트라이크와_볼이_없으면_낫싱() {
        assertThat(new GameResult(0, 0).toMessage()).isEqualTo("낫싱");
    }

    @Test
    void 스트라이크만_있으면_스트라이크만_표시() {
        assertThat(new GameResult(3, 0).toMessage()).isEqualTo("3스트라이크");
    }

    @Test
    void 볼만_있으면_볼만_표시() {
        assertThat(new GameResult(0, 2).toMessage()).isEqualTo("2볼");
    }

    @Test
    void 둘_다_있으면_볼_다음에_스트라이크() {
        assertThat(new GameResult(1, 1).toMessage()).isEqualTo("1볼 1스트라이크");
    }
}