package lotto;

import lotto.domain.LottoCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountTest {
    @DisplayName("100원일 경우 예외 발생")
    @Test
    void 백원_예외(){
        Assertions.assertThatThrownBy(()-> {
            new LottoCount(100);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }
    @DisplayName("1500원일 경우 예외 발생")
    @Test
    void 천오백원_예외(){
        Assertions.assertThatThrownBy(()-> {
            new LottoCount(1500);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("만원 지불 시 로또 갯수 10개")
    @Test
    void 만원지불시_열개(){
        LottoCount lottoCount = new LottoCount(10000);
        int count = lottoCount.getLottoCount();
        Assertions.assertThat(count).isEqualTo(10);
    }
    @DisplayName("오천원 지불 시 로또 갯수 5개")
    @Test
    void 오천원지불시_다섯개(){
        LottoCount lottoCount = new LottoCount(5000);
        int count = lottoCount.getLottoCount();
        Assertions.assertThat(count).isEqualTo(5);
    }
}
