package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    InputView inputView = new InputView();

    public void playGame(){
        int payment = inputView.getPayment();
    }
}
