package com.lendico.finance.planner.algorithm;

import com.lendico.finance.planner.model.Loan;

import java.util.List;

public interface LoanPlan<T> {
    List<T> getOptimalPlan(Loan loan);
}
