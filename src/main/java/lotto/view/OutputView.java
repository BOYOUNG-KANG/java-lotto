package lotto.view;

import lotto.messages.GameMessage;

import java.util.List;

public class OutputView {
    public void printLottos(int count, List<List<Integer>> lottos){
        System.out.println();
        System.out.println(count + GameMessage.OUTPUT_LOTTO_COUNT);
        for (int i = 0; i < count; i++) {
            System.out.println(lottos.get(i));
        }
    }
}
