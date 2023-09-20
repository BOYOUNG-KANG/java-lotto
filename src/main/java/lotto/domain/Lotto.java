package lotto.domain;

import lotto.messages.ValidateErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNumber;
    private List<List<Integer>> lottos;
    private Set<Integer> duplicatedCheckBox = new HashSet<>();

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

        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if(isOutOfRange(number)) throw new IllegalArgumentException(ValidateErrorMessage.RANGE_ERROR);
            duplicatedCheckBox.add(number);
        }
        if (isDuplicated()) throw new IllegalArgumentException(ValidateErrorMessage.DUPLICATE_ERROR);
    }

    private boolean isDuplicated() {
        return duplicatedCheckBox.size() != 6;
    }

    private void validate(int bonusNumber) {
        duplicatedCheckBox.add(bonusNumber);
        if (isOutOfRange(bonusNumber)) throw new IllegalArgumentException(ValidateErrorMessage.RANGE_ERROR);
        if (isDuplicatedWithNumbers()) throw new IllegalArgumentException(ValidateErrorMessage.DUPLICATE_ERROR);
    }

    private boolean isDuplicatedWithNumbers() {
        return duplicatedCheckBox.size() != 7;
    }

    private static boolean isOutOfRange(Integer number) {
        return number < 1 || number > 45;
    }
}
