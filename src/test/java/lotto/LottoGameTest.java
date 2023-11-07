package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    LottoGame lottoGame = new LottoGame();

    @DisplayName("로또 번호 5개와 보너스 번호가 일치하면 2등이다.")
    @Test
    void getWinningHistoryWithSeconde() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;

        assertThat(lottoGame.getWinningHistory(lottos, winningNumbers, bonusNumber).get(LottoRank.SECOND)).isEqualTo(1);
    }

    @DisplayName("로또 번호 5개만 일치하면 3등이다.")
    @Test
    void getWinningHistoryWithThird() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 8;

        assertThat(lottoGame.getWinningHistory(lottos, winningNumbers, bonusNumber).get(LottoRank.THIRD)).isEqualTo(1);
    }
}
