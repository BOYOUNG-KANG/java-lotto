package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoComputer;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoCount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGenerator generator = new LottoGenerator();

    public void playGame(){
        int payment = inputView.getPayment();
        LottoCount lottoCount = new LottoCount(payment);
        int count = lottoCount.getLottoCount();

        List<List<Integer>> lottos = generator.generate(count);
        outputView.printLottos(count, lottos);

        List<Integer> luckyNumbers = inputView.getLuckyNumbers();
        Lotto lotto = new Lotto(luckyNumbers);

        int bonusNumber = inputView.getBonusNumber();
        lotto.updateBonusNumber(bonusNumber);
        lotto.updateLottos(lottos);

        LottoComputer computer = new LottoComputer();
        Map<Enum, Integer> scoreBoard = computer.computeScore(lottos, luckyNumbers, bonusNumber);
        String profit = computer.computeProfit(payment, scoreBoard);
        outputView.printRewardScore(scoreBoard);
        outputView.printProfit(profit);
    }
}
