package oraclePackage.resources;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class getMinCoinAlgoTest {
    @Test
    void getMinCoinCom() {
        double[] coinDemo = {3.00, 4.00, 8.00};
//        List<Double> expectedResult = {3.00, 4.00};
        ArrayList<Double> expectedResult = new ArrayList<Double>();
        expectedResult.add(3.00);
        expectedResult.add(4.00);
        getMinCoinAlgo algo = new getMinCoinAlgo();
        assertEquals(expectedResult, algo.calculateMinimumCoins(7, coinDemo));
    }
}