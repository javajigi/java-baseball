package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.GameResult;
import baseball.domain.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {

    private static final String RESTART = "1";
    private static final String QUIT = "2";

    private final NumberGenerator numberGenerator = new NumberGenerator();

    public void run() {
        OutputView.printStart();
        do {
            play();
        } while (askRestart());
    }

    private void play() {
        BaseballNumbers answer = new BaseballNumbers(numberGenerator.generate());
        GameResult result;
        do {
            result = guess(answer);
        } while (!result.isThreeStrike());
        OutputView.printEnd();
    }

    private GameResult guess(BaseballNumbers answer) {
        BaseballNumbers input = new BaseballNumbers(InputView.readNumbers());
        GameResult result = answer.compare(input);
        OutputView.printResult(result.toMessage());
        return result;
    }

    private boolean askRestart() {
        String input = InputView.readRestart();

        if (RESTART.equals(input)) {
            return true;
        }
        if (QUIT.equals(input)) {
            return false;
        }
        throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
    }
}