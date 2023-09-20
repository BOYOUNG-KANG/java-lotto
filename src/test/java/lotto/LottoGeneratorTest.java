package lotto;

import lotto.domain.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoGeneratorTest {
    @DisplayName("로또갯수가 1개일때 1개 로또 생성")
    @Test
    void 한개로또_생성(){
        LottoGenerator generator = new LottoGenerator();
        List<List<Integer>> lottos = generator.generate(1);
        Assertions.assertThat(lottos.size()).isEqualTo(1);
    }

    @DisplayName("로또갯수가 3개일때 3개 로또 생성")
    @Test
    void 세개로또_생성(){
        LottoGenerator generator = new LottoGenerator();
        List<List<Integer>> lottos = generator.generate(3);
        Assertions.assertThat(lottos.size()).isEqualTo(3);
    }

    @DisplayName("로또갯수가 8개일때 8개 로또 생성")
    @Test
    void 여덟개로또_생성(){
        LottoGenerator generator = new LottoGenerator();
        List<List<Integer>> lottos = generator.generate(8);
        Assertions.assertThat(lottos.size()).isEqualTo(8);
    }
}