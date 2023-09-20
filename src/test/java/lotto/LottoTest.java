package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호가 1부터 45의 범위가 아니면 예외가 발생한다.")
    @Test
    void 범위_예외(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 70, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호 정상 처리")
    @Test
    void 정상(){
        assertDoesNotThrow(()-> {
            new Lotto(List.of(1, 2, 3, 4, 7, 5));
        });
    }

    @DisplayName("보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 보너스번호_중복_예외() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.updateBonusNumber(2))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호가 1부터 45의 범위가 아니면 예외가 발생한다.")
    @Test
    void 보너스번호_범위_예외(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.updateBonusNumber(70))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호 정상 처리")
    @Test
    void 보너스번호_정상(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.updateBonusNumber(7);
        assertDoesNotThrow(()-> {
            lotto.updateBonusNumber(7);
        });
    }
}
