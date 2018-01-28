package io.ta.datamanagement.dataplatform.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.ta.datamanagement.dataplatform.services.RouteService;

@RestController
public class RouteController {

    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping(value = "/api/route")
    public String addRoute(@RequestBody String route) throws Exception {
        return routeService.addRoute(route);
    }
}
