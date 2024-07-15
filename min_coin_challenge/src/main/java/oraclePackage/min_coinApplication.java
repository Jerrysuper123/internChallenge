package oraclePackage;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import jakarta.servlet.DispatcherType;
import oraclePackage.resources.getMinCoinAlgo;
import oraclePackage.resources.getMiniCoin;
import jakarta.servlet.FilterRegistration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import java.util.EnumSet;

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


        //Below is to allow cors
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        cors.setInitParameter(CrossOriginFilter.CHAIN_PREFLIGHT_PARAM, Boolean.FALSE.toString());
    }

}
