package com.lendico.finance.planner.model;

import java.util.Date;

public class Loan {
    private double loanAmount;
    private double nominalRate;
    private int duration;
    private Date startDate;

    public Loan() {
    }

    public Loan(double loanAmount, double nominalRate, int duration, Date startDate) {
        this.loanAmount = loanAmount;
        this.nominalRate = nominalRate;
        this.duration = duration;
        this.startDate = startDate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Loan setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
        return this;
    }

    public double getNominalRate() {
        return nominalRate;
    }

    public Loan setNominalRate(double nominalRate) {
        this.nominalRate = nominalRate;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public Loan setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Loan setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }
}
