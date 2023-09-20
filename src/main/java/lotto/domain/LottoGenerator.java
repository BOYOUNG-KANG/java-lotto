package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    public List<List<Integer>> generate(int lottoCount){
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_MIN_RANGE, LottoConstant.LOTTO_MAX_RANGE, LottoConstant.LOTTO_COUNT);
            lottos.add(sortByAscendingOrder(lotto));
        }
        return lottos;
    }
    private List<Integer> sortByAscendingOrder(List<Integer> lotto){
        return lotto
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
