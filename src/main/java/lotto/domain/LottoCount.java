package lotto.domain;

import lotto.messages.ValidateErrorMessage;

public class LottoCount {

    public int lottoCount;

    public LottoCount(int payment) {
        validate(payment);
        int lottoCount = getLottoCount(payment);
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void validate(int payment){
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(ValidateErrorMessage.PAYMENT_ERROR);
        }
    }
    public int getLottoCount(int payment){
        return payment / 1000;
    }
}
