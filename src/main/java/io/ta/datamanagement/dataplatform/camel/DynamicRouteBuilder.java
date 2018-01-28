package io.ta.datamanagement.dataplatform.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

public class DynamicRouteBuilder extends RouteBuilder {

    public static final String ACTIVEMQ = "activemq:";

    private static final String FROM = "measuredData";

    private static final String HELLO_FROM_CAMEL = "Hello from Camel";

    private static final String LOG = "log:";

    private static String TIMER_BAR = "timer:bar";

    private final String to;

    public DynamicRouteBuilder(CamelContext context, String to) {
        super(context);
        this.to = to;
    }

    @Override
    public void configure() throws Exception {
        from(ACTIVEMQ + FROM)
                .to(LOG + to)
                .to(ACTIVEMQ + to);

        from(TIMER_BAR)
                .setBody(constant(HELLO_FROM_CAMEL))
                .to(ACTIVEMQ + FROM);
    }

}
