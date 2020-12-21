package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBallNumber {
    public static final int MIN_VALID_NUMBER = 1;
    public static final int MAX_VALID_NUMBER = 9;

    private static class BaseBallNumberCache {
        private static final List<BaseBallNumber> BASE_BALL_NUMBERS = new ArrayList<>();

        static {
            for (int i = MIN_VALID_NUMBER; i <= MAX_VALID_NUMBER; i++) {
                BASE_BALL_NUMBERS.add(new BaseBallNumber(i));
            }
        }

        private static BaseBallNumber valueOf(int number) {
            try {
                return BASE_BALL_NUMBERS.get(number - 1);
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("1~9 사이의 숫자만 허용됩니다.");
            }
        }
    }

    public static BaseBallNumber valueOf(int number) {
        return BaseBallNumberCache.valueOf(number);
    }

    private final int number;

    private BaseBallNumber(int number) {
        requireInRangeOneToNine(number);

        this.number = number;
    }

    private void requireInRangeOneToNine(int number) {
        if (number < MIN_VALID_NUMBER || number > MAX_VALID_NUMBER) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 허용됩니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
