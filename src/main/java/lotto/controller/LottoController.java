package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoCount;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    InputView inputView = new InputView();

    public void playGame(){
        LottoCount lottoCount = new LottoCount(inputView.getPayment());
        int count = lottoCount.getLottoCount();

        LottoGenerator generator = new LottoGenerator();
        List<List<Integer>> lottos = generator.generate(count);

    }
}
