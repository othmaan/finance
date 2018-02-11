package com.lendico.finance.planner.operation;

import com.lendico.finance.common.exception.ApiException;
import com.lendico.finance.planner.algorithm.FixedAnnuity;
import com.lendico.finance.planner.algorithm.LoanPlan;
import com.lendico.finance.planner.client.GeneratePlanRequest;
import com.lendico.finance.planner.client.GeneratePlanResponse;
import com.lendico.finance.planner.model.Loan;

import java.util.List;

// Context //
public class PlannerOperation {


    // Eagerly instantiate with defaults
    public static LoanPlan loanPlan = new FixedAnnuity();


    public List generatePlan(GeneratePlanRequest request) throws ApiException {

        // 1. Select algorithm
        PlannerOperation.loanPlan = new FixedAnnuity();

        // 2. Get loan from client request
        Loan loan = request.map();

        // 3. Plan is list on installments
        List optimalPlan = loanPlan.getOptimalPlan(loan);

        // 4. Build client response
        GeneratePlanResponse response = new GeneratePlanResponse();

        // 5.
        return response.buildManyToMany(optimalPlan);
    }
}
