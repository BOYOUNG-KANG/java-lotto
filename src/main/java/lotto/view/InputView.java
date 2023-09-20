package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.messages.GameMessage;

public class InputView {
    public int getPayment(){
        System.out.println(GameMessage.INPUT_PAYMENT_MESSAGE);
        return Integer.valueOf(Console.readLine());
    }
}
