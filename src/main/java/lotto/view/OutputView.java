package lotto.view;

import lotto.domain.Score;
import lotto.messages.GameMessage;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottos(int count, List<List<Integer>> lottos){
        System.out.println();
        System.out.println(count + GameMessage.OUTPUT_LOTTO_COUNT);
        for (int i = 0; i < count; i++) {
            System.out.println(lottos.get(i));
        }
    }
    public void printRewardScore(Map<Enum, Integer> scoreBoard){
        System.out.println(GameMessage.OUTPUT_REWARD_INTRO);
        System.out.println(GameMessage.BLANK);
        System.out.println(GameMessage.THREE + scoreBoard.get(Score.THREE_MATCH) + GameMessage.COUNT);
        System.out.println(GameMessage.FOUR + scoreBoard.get(Score.FOUR_MATCH) + GameMessage.COUNT);
        System.out.println(GameMessage.FIVE + scoreBoard.get(Score.FIVE_MATCH) + GameMessage.COUNT);
        System.out.println(GameMessage.FIVE_AND_BONUS + scoreBoard.get(Score.FIVE_AND_BONUS_MATCH) + GameMessage.COUNT);
        System.out.println(GameMessage.SIX + scoreBoard.get(Score.SIX_MATCH) + GameMessage.COUNT);
    }
    public void printProfit(String profit){
        System.out.println(GameMessage.PROFIT_START+profit+GameMessage.PROFIT_END);
    }
}