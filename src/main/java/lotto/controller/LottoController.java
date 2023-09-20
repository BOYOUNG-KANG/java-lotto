package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoCount;
import lotto.view.InputView;

public class LottoController {
    InputView inputView = new InputView();

    public void playGame(){
        LottoCount lottoCount = new LottoCount(inputView.getPayment());
        int count = lottoCount.getLottoCount();

    }
}
