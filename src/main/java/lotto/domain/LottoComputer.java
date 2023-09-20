package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoComputer {
    private Map<Enum, Integer> scoreBoard = new HashMap<>();
    private Map<Enum, Integer> rewardBoard = new HashMap<>();

    public Map<Enum, Integer> computeScore(List<List<Integer>> lottos, List<Integer> luckyNumbers, int bonusNumber){
        setUpScoreBoard();
        matchScore(lottos, luckyNumbers, bonusNumber);
        return scoreBoard;
    }
    public String computeProfit(int payment, Map<Enum, Integer> scoreBoard){
        setUpRewordBoard();
        float totalReward = countTotalReward(scoreBoard);
        return getProfit(totalReward, payment);
    }

    private static String getProfit(float totalReward, int payment) {
        float pay = payment;
        float profit = totalReward / pay * LottoConstant.HUNDRED;
        return String.format("%.2f", profit);
    }

    private int countTotalReward(Map<Enum, Integer> scoreBoard) {
        int totalReward = 0;
        totalReward = getReward(scoreBoard, totalReward, Score.THREE_MATCH);
        totalReward = getReward(scoreBoard, totalReward, Score.FOUR_MATCH);
        totalReward = getReward(scoreBoard, totalReward, Score.FIVE_MATCH);
        totalReward = getReward(scoreBoard, totalReward, Score.FIVE_AND_BONUS_MATCH);
        totalReward = getReward(scoreBoard, totalReward, Score.SIX_MATCH);
        return totalReward;
    }

    private int getReward(Map<Enum, Integer> scoreBoard, int totalReward, Score score) {
        Integer count = scoreBoard.get(score);
        Integer reward = rewardBoard.get(score);
        totalReward += count * reward;
        return totalReward;
    }

    private void matchScore(List<List<Integer>> lottos, List<Integer> luckyNumbers, int bonusNumber) {
        for (List<Integer> lotto : lottos) {
            int luckyNumberScore = 0; int bonusNumberScore = 0;
            luckyNumberScore = matchLuckNumber(luckyNumbers, lotto, luckyNumberScore);
            bonusNumberScore = matchBonusNumber(bonusNumber, lotto, bonusNumberScore);
            updateScoreBoard(luckyNumberScore, bonusNumberScore);
        }
    }

    private void updateScoreBoard(int luckyNumberScore, int bonusNumberScore) {
        int totalNumberScore = luckyNumberScore + bonusNumberScore;
        updateScore(totalNumberScore, 3, Score.THREE_MATCH);
        updateScore(totalNumberScore, 4, Score.FOUR_MATCH);
        updateScore(totalNumberScore, 5, Score.FIVE_MATCH);
        if (totalNumberScore == 6) {
            updateScoreWhen6(bonusNumberScore, 1, Score.FIVE_AND_BONUS_MATCH);
            updateScoreWhen6(bonusNumberScore, 0, Score.SIX_MATCH);
        }
    }

    private void updateScoreWhen6(int bonusNumberScore, int x, Score fiveAndBonusMatch) {
        if (bonusNumberScore == x) {
            Integer nowScore = scoreBoard.get(fiveAndBonusMatch);
            scoreBoard.put(fiveAndBonusMatch, nowScore + 1);
        }
    }

    private void updateScore(int totalNumberScore, int x, Score fiveMatch) {
        if (totalNumberScore == x) {
            Integer nowScore = scoreBoard.get(fiveMatch);
            scoreBoard.put(fiveMatch, nowScore + 1);
        }
    }

    private static int matchBonusNumber(int bonusNumber, List<Integer> lotto, int bonusNumberScore) {
        if (lotto.contains(bonusNumber)) bonusNumberScore++;
        return bonusNumberScore;
    }

    private static int matchLuckNumber(List<Integer> luckyNumbers, List<Integer> lotto, int luckyNumberScore) {
        for (Integer luckyNumber : luckyNumbers) {
            luckyNumberScore = matchBonusNumber(luckyNumber, lotto, luckyNumberScore);
        }
        return luckyNumberScore;
    }

    private void setUpScoreBoard(){
        scoreBoard.putAll(Map.of(
                Score.THREE_MATCH, 0,
                Score.FOUR_MATCH, 0,
                Score.FIVE_MATCH, 0,
                Score.FIVE_AND_BONUS_MATCH, 0,
                Score.SIX_MATCH, 0
        ));
    }
    private void setUpRewordBoard(){
        rewardBoard.putAll(Map.of(
                Score.THREE_MATCH, LottoConstant.REWARD_THREE,
                Score.FOUR_MATCH, LottoConstant.REWARD_FOUR,
                Score.FIVE_MATCH, LottoConstant.REWARD_FIVE,
                Score.FIVE_AND_BONUS_MATCH, LottoConstant.REWARD_FIVE_AND_BONUS,
                Score.SIX_MATCH, LottoConstant.REWARD_SIX
        ));
    }
}