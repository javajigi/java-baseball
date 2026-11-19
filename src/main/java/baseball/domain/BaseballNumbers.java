package baseball.domain;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballNumbers {

    private static final int SIZE = 3;

    private final List<Integer> numbers;

    public BaseballNumbers(String input) {
        validateLength(input);
        validateRange(input);
        this.numbers = toNumbers(input);
        validateDuplicate(numbers);
    }

    public BaseballNumbers(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateLength(String input) {
        if (input == null || input.length() != SIZE) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
    }

    private void validateRange(String input) {
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("1부터 9 사이의 숫자만 입력할 수 있습니다.");
            }
        }
    }

    private List<Integer> toNumbers(String input) {
        List<Integer> result = new ArrayList<>();
        for (char c : input.toCharArray()) {
            result.add(c - '0');
        }
        return result;
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
    }

    public GameResult compare(BaseballNumbers other) {
        int strike = countStrike(other);
        int ball = countBall(other);
        return new GameResult(strike, ball);
    }

    private int countStrike(BaseballNumbers other) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {

            if (numbers.get(i).equals(other.numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(BaseballNumbers other) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            int target = other.numbers.get(i);
            if (numbers.contains(target) && !numbers.get(i).equals(target)) {
                count++;
            }
        }
        return count;
    }
}