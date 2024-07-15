package oraclePackage;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import oraclePackage.resources.getMinCoinAlgo;
import oraclePackage.resources.getMiniCoin;

public class min_coinApplication extends Application<min_coinConfiguration> {

    public static void main(final String[] args) throws Exception {
        new min_coinApplication().run(args);
    }

    @Override
    public String getName() {
        return "min_coin";
    }

    @Override
    public void initialize(final Bootstrap<min_coinConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final min_coinConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        //register the resource
        environment.jersey().register(new getMiniCoin());
//        environment.jersey().register(new getMinCoinAlgo());
//        environment.healthChecks().register();
    }

}
