package com.lendico.finance.planner.resource;

import com.lendico.finance.planner.client.GeneratePlanRequest;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Component
@Path("/planner")
public interface PlannerEndpoints {

    @POST
    @Path("/generate-plan")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List generatePlan(GeneratePlanRequest request);
}
