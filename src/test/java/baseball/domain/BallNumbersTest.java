package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallNumbersTest {
    @DisplayName("1~9 사이의 서로 다른 수로 이루어진 임의의 세자리 문자열로 BallNumbers를 생성한다")
    @Test
    void create() {
        assertThat(BallNumbers.from("123").getNumbers())
                .isEqualTo(Arrays.asList(1, 2, 3));
    }

    @DisplayName("입력 문자열이 1~9 사이의 숫자가 아닌 문자열일 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"032", "a32"})
    void validateNumber(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BallNumbers.from(input))
                .withMessage("1~9 사이의 숫자만 허용됩니다.");
    }
}