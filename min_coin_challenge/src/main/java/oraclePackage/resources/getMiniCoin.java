package oraclePackage.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;


@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class getMiniCoin {

    @GET
    public String returnHello(){
        return "hello world! this is a GET request. you backend is working on http://localhost:8080/hello";
    }
    getMinCoinAlgo algo = new getMinCoinAlgo();

    //When created below, this will be what the body looks like when user send over as body
    public static class CoinChange {
        public double targetAmount;
        public double[] coinDenominators;
    }
    @POST
    public List<Double> getCoin(final CoinChange coinChange) {
//why sout cannot see anything
//        System.out.println(coinChange.targetAmount);
//        System.out.println(coinChange.coinDenominators);
        return algo.calculateMinimumCoins( coinChange.targetAmount, coinChange.coinDenominators);
    }
}
