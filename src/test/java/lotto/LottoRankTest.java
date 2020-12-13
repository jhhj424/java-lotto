package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {

    @DisplayName("당첨 결과에 따른 당첨 금액을 구한다")
    @ParameterizedTest
    @CsvSource(value = {"3,5000", "4,50000", "5,1500000", "6,2000000000"})
    public void findRank(int winningCount, int expectedReward) {
        //when
        LottoRank lottoRank = LottoRank.getLottoRank(winningCount);

        //then
        assertEquals(expectedReward, lottoRank.reward());
    }
    
    @Test
    @DisplayName("구입 금액 대비 당첨 금액에 따른 수익률을 구한다.")
    public void returnRewardRatio() {
        //given
        int purchaseAmount = 14_000;
        long totalReward = 5_000;
        Lotto lotto = new Lotto(purchaseAmount);

        //when
        double rewardRatio = lotto.rewardRatio(totalReward);

        //then
        assertEquals(0.35, rewardRatio);
    }
}
