package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.messages.GameMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public int getPayment(){
        System.out.println(GameMessage.INPUT_PAYMENT_MESSAGE);
        return Integer.valueOf(Console.readLine());
    }
    public List<Integer> getLuckyNumbers(){
        System.out.println(GameMessage.INPUT_LUCKY_NUMBER);
        String numbers = Console.readLine();
        return convertToList(numbers);
    }
    public int getBonusNumber(){
        System.out.println(GameMessage.INPUT_BONUS_NUMBER);
        return Integer.valueOf(Console.readLine());
    }
    private List<Integer> convertToList(String luckyNumbers){
       List<Integer> convertedNumbers = new ArrayList<>();
        String[] numbers = luckyNumbers.split(",");
        for (String number : numbers) {
            Integer convertedNumber = Integer.valueOf(number);
            convertedNumbers.add(convertedNumber);
        }
        System.out.println("convertedNumbers = " + convertedNumbers);
        return convertedNumbers;
    }
}
