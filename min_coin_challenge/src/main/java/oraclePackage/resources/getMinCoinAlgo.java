package oraclePackage.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class getMinCoinAlgo {
    public static void main(String[] args) {
        double targetAmount = 7.03;
        double[] coinDenominations = { 0.1, 0.5, 1 };

        List<Double> result = calculateMinimumCoins(targetAmount, coinDenominations);

        System.out.println("Input:");
        System.out.println("Target amount: " + targetAmount);
        System.out.println("Coin denominations: " + Arrays.toString(coinDenominations));
        System.out.println("Output:");
        System.out.println(result);
    }

    public static    List<Double> calculateMinimumCoins(double targetAmount, double[] coinDenominations) {
        // Sort the coin denominations in descending order
        Arrays.sort(coinDenominations);
        List<Double> result = new ArrayList<>();

        // Convert target amount to cents to avoid precision issues with double
        int cents = (int) Math.round(targetAmount * 100);

        // Iterate through denominations from largest to smallest
        for (int i = coinDenominations.length - 1; i >= 0; i--) {
            double denomination = coinDenominations[i];
            int count = cents / ((int) (denomination * 100)); // Number of coins of this denomination
            for (int j = 0; j < count; j++) {
                result.add(denomination);
            }
            cents %= (int) (denomination * 100); // Remaining amount after using current denomination
        }

        return result;
    }
}
