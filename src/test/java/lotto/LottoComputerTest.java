package lotto;

import lotto.domain.LottoComputer;
import lotto.domain.Score;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoComputerTest {
    @DisplayName("3개 일치하는 경우가 1번 있을 경우 3개일치 1개")
    @Test
    void 세개일치_한개(){
        List<Integer> luckyNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoComputer computer = new LottoComputer();
        List<List<Integer>> lottos = Arrays.asList(
                Arrays.asList(8, 21, 23, 41, 42, 43),
                Arrays.asList(3, 5, 11, 16, 32, 38),
                Arrays.asList(7, 11, 16, 35, 36, 44),
                Arrays.asList(1, 8, 11, 31, 41, 42),
                Arrays.asList(13, 14, 16, 38, 42, 45),
                Arrays.asList(7, 11, 30, 40, 42, 43),
                Arrays.asList(2, 13, 22, 32, 38, 45),
                Arrays.asList(1, 3, 5, 14, 22, 45)
        );
        int bonusNumber = 7;
        Map<Enum, Integer> score = computer.computeScore(lottos, luckyNumbers, bonusNumber);
        Assertions.assertThat(score.get(Score.THREE_MATCH)).isEqualTo(1);
    }
    @DisplayName("아무것도 일치하지 않는 경우 0개")
    @Test
    void 아무것도_x일치(){
        List<Integer> luckyNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoComputer computer = new LottoComputer();
        List<List<Integer>> lottos = Arrays.asList(
                Arrays.asList(8, 21, 23, 41, 42, 43),
                Arrays.asList(13, 15, 11, 16, 32, 38),
                Arrays.asList(17, 11, 16, 35, 36, 44),
                Arrays.asList(11, 18, 11, 31, 41, 42),
                Arrays.asList(13, 14, 16, 38, 42, 45),
                Arrays.asList(17, 11, 30, 40, 42, 43),
                Arrays.asList(12, 13, 22, 32, 38, 45),
                Arrays.asList(11, 13, 15, 14, 22, 45)
        );
        int bonusNumber = 7;
        Map<Enum, Integer> score = computer.computeScore(lottos, luckyNumbers, bonusNumber);
        Assertions.assertThat(score.get(Score.THREE_MATCH)).isEqualTo(0);
    }
    @DisplayName("5개 일치보너스볼 1개, 3개일치 1개, 6개일치 2개")
    @Test
    void 네개(){
        List<Integer> luckyNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoComputer computer = new LottoComputer();
        List<List<Integer>> lottos = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 8, 11, 31, 41, 42),
                Arrays.asList(13, 14, 16, 38, 42, 45),
                Arrays.asList(7, 11, 30, 40, 42, 43),
                Arrays.asList(2, 13, 22, 32, 38, 45),
                Arrays.asList(1, 3, 5, 14, 22, 45)
        );
        int bonusNumber = 7;
        Map<Enum, Integer> score = computer.computeScore(lottos, luckyNumbers, bonusNumber);
        Assertions.assertThat(score.get(Score.THREE_MATCH)).isEqualTo(1);
        Assertions.assertThat(score.get(Score.FIVE_AND_BONUS_MATCH)).isEqualTo(1);
        Assertions.assertThat(score.get(Score.SIX_MATCH)).isEqualTo(2);
    }
}
