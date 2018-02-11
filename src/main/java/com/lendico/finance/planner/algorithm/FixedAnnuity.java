package com.lendico.finance.planner.algorithm;

import com.lendico.finance.common.util.Constants;
import com.lendico.finance.planner.model.Installment;
import com.lendico.finance.planner.model.Loan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.lendico.finance.common.util.Utils.getTimeSeriesFromDuration;
import static com.lendico.finance.common.util.Utils.twoDecimalPlaces;

public class FixedAnnuity implements LoanPlan {

    public List getOptimalPlan(Loan loan) {

        // 1. Calculate annuity
        double annuityAmount = calculateFixedAnnuity(loan);

        // 2. Get date time series
        List<Installment> installments = new ArrayList<>();
        List timeSeries = getTimeSeriesFromDuration(loan.getStartDate(), loan.getDuration());

        // 3.
        double initialOutstanding = loan.getLoanAmount();
        double interest = calculateInterest(loan.getNominalRate(), initialOutstanding);
        double principal = calculatePrinciple(annuityAmount, interest);
        double remainingOutstanding = calculateRemainingOutstanding(initialOutstanding, principal);

        for (Object date : timeSeries) {

            // 1.
            Installment installment = new Installment()
                    .setDate((Date) date)
                    .setPrincipal(principal)
                    .setBorrowerPaymentAmount(annuityAmount)
                    .setInitialOutstandingPrincipal(initialOutstanding)
                    .setRemainingOutstandingPrincipal(remainingOutstanding)
                    .setInterest(interest);

            // 2.
            installments.add(installment);

            // 3.
            initialOutstanding = twoDecimalPlaces(installment.getRemainingOutstandingPrincipal());
            interest = calculateInterest(loan.getNominalRate(), initialOutstanding);
            principal = calculatePrinciple(installment.getBorrowerPaymentAmount(), interest);
            remainingOutstanding = calculateRemainingOutstanding(installment.getRemainingOutstandingPrincipal(), principal);
        }

        return installments;
    }

    private double calculateFixedAnnuity(Loan loan) {
        double price = loan.getLoanAmount();
        double interestRate = loan.getNominalRate() / Constants.MONTHS_IN_YEAR / Constants.PERCENTILE;
        double p1 = interestRate + 1;
        double np1 = 1;
        for (int i = 0; i < loan.getDuration(); i++) {
            np1 = p1 * np1;
        }
        double annuity = interestRate * np1 * Constants.PERCENTILE / (np1 - 1);
        double monthlyPayment = price * annuity / Constants.PERCENTILE;
        return twoDecimalPlaces(monthlyPayment);
    }

    private double calculateInterest(double nominalRate, double initialOutstanding) {
        return twoDecimalPlaces(nominalRate * Constants.DAYS_OF_MONTH * initialOutstanding / Constants.DAYS_IN_YEAR / Constants.PERCENTILE);
    }

    private double calculatePrinciple(double annuityAmount, double interest) {
        return twoDecimalPlaces(annuityAmount - interest);
    }

    private double calculateRemainingOutstanding(double initialOutstanding, double principal) {
        return twoDecimalPlaces(initialOutstanding > principal ? initialOutstanding - principal : Constants.LAST_REMAINING_OUTSTANDING);
    }
}


/*
 Ref.
    https://extloancalculator.com/calculators/free-online-annuity-calculator.html
    http://www.annuitycalc.org/
*/
