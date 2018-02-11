package com.lendico.finance;

import com.lendico.finance.planner.resource.PlannerResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(PlannerResource.class);
    }
}
