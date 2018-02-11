package com.lendico.finance.planner.model;

import java.util.Date;

public class Installment {
    private double borrowerPaymentAmount;
    private Date date;
    private double initialOutstandingPrincipal;
    private double interest;
    private double principal;
    private double remainingOutstandingPrincipal;

    public Installment() {
    }

    public Installment(double borrowerPaymentAmount, Date date, double initialOutstandingPrincipal, double interest, double principal, double remainingOutstandingPrincipal) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
        this.date = date;
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
        this.interest = interest;
        this.principal = principal;
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
    }

    public double getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public Installment setBorrowerPaymentAmount(double borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Installment setDate(Date date) {
        this.date = date;
        return this;
    }

    public double getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public Installment setInitialOutstandingPrincipal(double initialOutstandingPrincipal) {
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
        return this;
    }

    public double getInterest() {
        return interest;
    }

    public Installment setInterest(double interest) {
        this.interest = interest;
        return this;
    }

    public double getPrincipal() {
        return principal;
    }

    public Installment setPrincipal(double principal) {
        this.principal = principal;
        return this;
    }

    public double getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    public Installment setRemainingOutstandingPrincipal(double remainingOutstandingPrincipal) {
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
        return this;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "borrowerPaymentAmount=" + borrowerPaymentAmount +
                ", date=" + date +
                ", initialOutstandingPrincipal=" + initialOutstandingPrincipal +
                ", interest=" + interest +
                ", principal=" + principal +
                ", remainingOutstandingPrincipal=" + remainingOutstandingPrincipal +
                '}';
    }
}
