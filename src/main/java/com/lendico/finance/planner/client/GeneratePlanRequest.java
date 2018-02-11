package com.lendico.finance.planner.client;

import com.lendico.finance.common.exception.ApiException;
import com.lendico.finance.common.protocol.ClientToBusiness;
import com.lendico.finance.planner.model.Loan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.lendico.finance.common.util.Constants.CLIENT_DATE_FORMAT;
import static com.lendico.finance.common.util.Constants.ERROR_CODES;
import static com.lendico.finance.common.util.Utils.twoDecimalPlacesString;

public class GeneratePlanRequest implements ClientToBusiness<Loan> {

    private String loanAmount;
    private String nominalRate;
    private String duration;
    private String startDate;

    public String getLoanAmount() {
        return loanAmount;
    }

    public GeneratePlanRequest setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
        return this;
    }

    public String getNominalRate() {
        return nominalRate;
    }

    public GeneratePlanRequest setNominalRate(String nominalRate) {
        this.nominalRate = nominalRate;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public GeneratePlanRequest setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public GeneratePlanRequest setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public Loan map() throws ApiException {
        SimpleDateFormat df = new SimpleDateFormat(CLIENT_DATE_FORMAT);
        Date d;
        Loan loan;
        try {
            d = df.parse(getStartDate());
            loan = new Loan()
                    .setStartDate(d)
                    .setNominalRate(twoDecimalPlacesString(getNominalRate()))
                    .setLoanAmount(twoDecimalPlacesString(getLoanAmount()))
                    .setDuration(Integer.valueOf(getDuration()));

        } catch (ParseException | NullPointerException | NumberFormatException e) {
            throw new ApiException(ERROR_CODES.PARSER, "Parsing Error.");
        }
        return loan;
    }
}
