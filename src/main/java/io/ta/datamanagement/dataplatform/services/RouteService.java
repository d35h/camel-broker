package io.ta.datamanagement.dataplatform.services;

import org.apache.camel.CamelContext;
import org.springframework.stereotype.Component;

import io.ta.datamanagement.dataplatform.camel.DynamicRouteBuilder;

@Component
public class RouteService {

    private final CamelContext camelContext;

    public RouteService(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public String addRoute(String route) throws Exception {
        camelContext.addRoutes(new DynamicRouteBuilder(camelContext, route));
        return camelContext.getEndpoint(DynamicRouteBuilder.ACTIVEMQ + route).getEndpointUri();
    }

}
