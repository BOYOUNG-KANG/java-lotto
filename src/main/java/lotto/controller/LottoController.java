package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoCount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void playGame(){
        LottoCount lottoCount = new LottoCount(inputView.getPayment());
        int count = lottoCount.getLottoCount();

        LottoGenerator generator = new LottoGenerator();
        List<List<Integer>> lottos = generator.generate(count);
        outputView.printLottos(count, lottos);


    }
}
