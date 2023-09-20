package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.messages.GameMessage;
import lotto.messages.ValidateErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int getPayment() {
        try {
            System.out.println(GameMessage.INPUT_PAYMENT_MESSAGE);
            String payment = Console.readLine();
            System.out.println();
            return convertToInt(payment);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return 0;
        }
    }

    private static int convertToInt(String payment) {
        try {
            return Integer.parseInt(payment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateErrorMessage.PAYMENT_TYPE_ERROR);
        }
    }

    public List<Integer> getLuckyNumbers(){
        System.out.println(GameMessage.INPUT_LUCKY_NUMBER);
        String numbers = Console.readLine();
        try {
            return convertToList(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ValidateErrorMessage.TYPE_ERROR);
        }
    }
    public int getBonusNumber(){
        System.out.println(GameMessage.INPUT_BONUS_NUMBER);
        try {
            return Integer.valueOf(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateErrorMessage.BONUS_COUNT_ERROR);
        }
    }
    private List<Integer> convertToList(String luckyNumbers){
       List<Integer> convertedNumbers = new ArrayList<>();
        String[] numbers = luckyNumbers.split(",");
        for (String number : numbers) {
            Integer convertedNumber = Integer.valueOf(number);
            convertedNumbers.add(convertedNumber);
        }
        return convertedNumbers;
    }
}