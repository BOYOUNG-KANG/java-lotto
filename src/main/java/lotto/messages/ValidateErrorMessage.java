package lotto.messages;

public class ValidateErrorMessage {
    public static final String PAYMENT_ERROR = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    public static final String RANGE_ERROR = "[ERROR] 로또 번호의 숫자 범위는 1~45까지 입니다.";
    public static final String LUCKY_COUNT_ERROR = "[ERROR] 당첨 번호는 6개의 숫자를 선택해야 합니다.";
    public static final String BONUS_COUNT_ERROR = "[ERROR] 보너스 번호는 1개의 숫자를 선택해야 합니다.";
    public static final String TYPE_ERROR = "[ERROR] 당첨 번호는 숫자로 입력이 가능하고, 번호 구분은 쉼표(,)로 해주셔야 합니다.";
    public static final String DUPLICATE_ERROR = "[ERROR] 서로 다른 숫자여야 합니다.";


}
