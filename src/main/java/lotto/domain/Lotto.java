package lotto.domain;

import lotto.messages.ValidateErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNumber;
    private List<List<Integer>> lottos;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void updateLottos(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public void updateBonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException(ValidateErrorMessage.LUCKY_COUNT_ERROR);

        Set<Integer> duplicatedCheckBox = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if(number < 1 || number > 45) throw new IllegalArgumentException(ValidateErrorMessage.RANGE_ERROR);
            duplicatedCheckBox.add(number);
        }
        if (duplicatedCheckBox.size() != 6) throw new IllegalArgumentException(ValidateErrorMessage.DUPLICATE_ERROR);
    }
    private void validate(int bonusNumber) {

    }

    // TODO: 추가 기능 구현
}
