package com.lendico.finance.planner.resource;

import com.lendico.finance.common.exception.ApiException;
import com.lendico.finance.planner.client.GeneratePlanRequest;
import com.lendico.finance.planner.operation.PlannerOperation;

import java.util.List;

public class PlannerResource implements PlannerEndpoints {

    private final PlannerOperation operation = new PlannerOperation();

    @Override
    public List generatePlan(GeneratePlanRequest request) throws ApiException {
        return operation.generatePlan(request);
    }
}
