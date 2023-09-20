package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private List<List<Integer>> lottos;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void updateLottos(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
