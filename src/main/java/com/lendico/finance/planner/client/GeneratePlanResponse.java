package com.lendico.finance.planner.client;

import com.lendico.finance.common.exception.ApiException;
import com.lendico.finance.common.protocol.BusinessToClient;
import com.lendico.finance.common.util.Constants;
import com.lendico.finance.planner.model.Installment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.lendico.finance.common.util.Utils.twoDecimalPlaces;

public class GeneratePlanResponse implements BusinessToClient<Installment> {
    private String borrowerPaymentAmount;
    private String date;
    private String initialOutstandingPrincipal;
    private String interest;
    private String principal;
    private String remainingOutstandingPrincipal;

    public String getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public GeneratePlanResponse setBorrowerPaymentAmount(String borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
        return this;
    }

    public String getDate() {
        return date;
    }

    public GeneratePlanResponse setDate(String date) {
        this.date = date;
        return this;
    }

    public String getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public GeneratePlanResponse setInitialOutstandingPrincipal(String initialOutstandingPrincipal) {
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
        return this;
    }

    public String getInterest() {
        return interest;
    }

    public GeneratePlanResponse setInterest(String interest) {
        this.interest = interest;
        return this;
    }

    public String getPrincipal() {
        return principal;
    }

    public GeneratePlanResponse setPrincipal(String principal) {
        this.principal = principal;
        return this;
    }

    public String getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    public GeneratePlanResponse setRemainingOutstandingPrincipal(String remainingOutstandingPrincipal) {
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
        return this;
    }

    @Override
    public GeneratePlanResponse buildOneToOne(Installment i) throws ApiException {
        SimpleDateFormat df = new SimpleDateFormat(Constants.CLIENT_DATE_FORMAT);
        setDate(df.format(i.getDate()));
        setBorrowerPaymentAmount(twoDecimalPlaces(String.valueOf(i.getBorrowerPaymentAmount())));
        setInitialOutstandingPrincipal(String.valueOf(i.getInitialOutstandingPrincipal()));
        setInterest(String.valueOf(i.getInterest()));
        setPrincipal(String.valueOf(i.getPrincipal()));
        setRemainingOutstandingPrincipal(String.valueOf(i.getRemainingOutstandingPrincipal()));
        return this;
    }

    @Override
    public List buildManyToMany(List<Installment> installments) throws ApiException {
        List<GeneratePlanResponse> response = new ArrayList<>();
        for (Installment i : installments) {
            response.add(buildOneToOne(i));
        }
        return response;
    }
}
