package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    private static final int SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    private final Random random = new Random();

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < SIZE) {
            int number = random.nextInt(MAX) + MIN;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }
}