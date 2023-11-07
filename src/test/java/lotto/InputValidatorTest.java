package lotto;

import io.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.ValidationErrorMessages.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    InputValidator validator = new InputValidator();

    @DisplayName("로또 구입 금액이 최소 금액 미만이면 예외가 발생한다.")
    @Test
    void validateLottoPurchaseAmountByBelowMinPurchaseAmount() {
        int lottoPurchaseAmount = 900;

        assertThatThrownBy(() -> validator.validateLottoPurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BELOW_MIN_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void validateLottoPurchaseAmountByNotMultipleOfPrice() {
        int lottoPurchaseAmount = 2100;

        assertThatThrownBy(() -> validator.validateLottoPurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_MULTIPLE_OF_PRICE.getMessage());
    }

    @DisplayName("로또 번호 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void validateWinningNumbersByBelowLottoSize() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호 개수가 6개보다 많으면 예외가 발생한다.")
    @Test
    void validateWinningNumbersByAboveLottoSize() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateWinningNumbersByDuplicatedLottoNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void validateWinningNumbersBy() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderRangeNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 0);

        assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER.getMessage());
    }
}
