package com.lendico.finance.planner.algorithm;

import static com.lendico.finance.common.util.Constants.*;

import com.lendico.finance.common.exception.ApiException;
import com.lendico.finance.planner.client.GeneratePlanRequest;
import com.lendico.finance.planner.operation.PlannerOperation;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FixedAnnuityTest {

    private final PlannerOperation operation = new PlannerOperation();
    private String today = new SimpleDateFormat(CLIENT_DATE_FORMAT).format(new Date().getTime());

    @Test(expected = ApiException.class)
    public void can_handle_invalid_input_decimal_duration() throws ApiException {

        // Exception: duration is decimal point
        GeneratePlanRequest twoYearsLoan = new GeneratePlanRequest()
                .setLoanAmount("5000")
                .setDuration("24.0")
                .setNominalRate("5.00")
                .setStartDate(today);

        operation.generatePlan(twoYearsLoan);
    }

    @Test(expected = ApiException.class)
    public void can_handle_invalid_input_null_duration() throws ApiException {

        // Exception: duration is null
        GeneratePlanRequest twoYearsLoan = new GeneratePlanRequest()
                .setLoanAmount("5000")
                .setDuration(null)
                .setNominalRate("5.00")
                .setStartDate(today);

        operation.generatePlan(twoYearsLoan);
    }

    @Test(expected = ApiException.class)
    public void can_handle_invalid_input_null_rate() throws ApiException {

        GeneratePlanRequest twoYearsLoan = new GeneratePlanRequest()
                .setLoanAmount("5000")
                .setDuration("24.0")
                .setNominalRate(null)
                .setStartDate(today);

        operation.generatePlan(twoYearsLoan);
    }

    @Test(expected = ApiException.class)
    public void can_handle_invalid_input_zero_rate() throws ApiException {

        GeneratePlanRequest twoYearsLoan = new GeneratePlanRequest()
                .setLoanAmount("5000")
                .setDuration("24")
                .setNominalRate("0.0")
                .setStartDate(today);

        operation.generatePlan(twoYearsLoan);
    }

    @Test(expected = ApiException.class)
    public void can_handle_invalid_input_null_start_date() throws ApiException {

        GeneratePlanRequest twoYearsLoan = new GeneratePlanRequest()
                .setLoanAmount("5000")
                .setDuration("24")
                .setNominalRate("5.00")
                .setStartDate(null);

        operation.generatePlan(twoYearsLoan);
    }

    @Test(expected = ApiException.class)
    public void can_handle_invalid_input_zero_amount() throws ApiException {

        GeneratePlanRequest twoYearsLoan = new GeneratePlanRequest()
                .setLoanAmount("0")
                .setDuration("24.0")
                .setNominalRate("0.0")
                .setStartDate(today);

        operation.generatePlan(twoYearsLoan);
    }

    @Test
    public void can_generate_plan_for_two_years() throws Exception {
        GeneratePlanRequest twoYearsLoan = new GeneratePlanRequest()
                .setLoanAmount("5000")
                .setDuration("24")
                .setNominalRate("5.00")
                .setStartDate(today);

        List list = operation.generatePlan(twoYearsLoan);

        assertNotNull("Plan should not be null.", list);

        assertEquals("Two years loan in 24 installments.", list.size(), 24);
    }

    @Test
    public void can_generate_plan_for_one_year() throws Exception {
        GeneratePlanRequest oneYearPlan = new GeneratePlanRequest()
                .setLoanAmount("5000")
                .setDuration("12")
                .setNominalRate("5.00")
                .setStartDate(today);

        List list = operation.generatePlan(oneYearPlan);

        assertNotNull("Plan should not be null.", list);

        assertEquals("One year loan in 12 installments.", list.size(), 12);
    }

    @Test
    public void can_generate_plan_for_one_month() throws Exception {
        GeneratePlanRequest oneMonthPlan = new GeneratePlanRequest()
                .setLoanAmount("5000")
                .setDuration("1")
                .setNominalRate("5.00")
                .setStartDate(today);

        List list = operation.generatePlan(oneMonthPlan);

        assertNotNull("Plan should not be null.", list);

        assertEquals("One month loan in 1 installment.", list.size(), 1);
    }

}
