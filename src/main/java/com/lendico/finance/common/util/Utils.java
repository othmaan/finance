package com.lendico.finance.common.util;

import com.lendico.finance.common.exception.ApiException;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.lendico.finance.common.util.Constants.CLIENT_NUMBER_FORMAT;
import static com.lendico.finance.common.util.Constants.ERROR_CODES;

public class Utils {

    private static final DecimalFormat df2 = new DecimalFormat(CLIENT_NUMBER_FORMAT);

    public static List getTimeSeriesFromDuration(Date startDate, int duration) {
        List<Object> series = new ArrayList<>();
        for (int i = 0; i < duration; i++) {
            Date d = new Date();
            d.setMonth(startDate.getMonth() + i);
            series.add(d);
        }
        return series;
    }

    public static double twoDecimalPlaces(double d) throws NumberFormatException {
        checkIfNull(d);
        return Double.valueOf(df2.format(d));
    }

    public static String twoDecimalPlaces(String d) throws NumberFormatException {
        checkIfNull(d);
        return df2.format(Double.valueOf(d));
    }

    public static double twoDecimalPlacesString(String d) throws NumberFormatException {
        checkIfNull(d);
        return Double.valueOf(df2.format(Double.valueOf(d)));
    }

    public static String twoDecimalPlacesString(double d) throws NumberFormatException {
        checkIfNull(d);
        return df2.format(d);
    }

    private static void checkIfNull(Object obj) {
        Boolean isNull = StringUtils.isEmpty(obj) || (obj.getClass() == Double.class && (double) obj == Double.POSITIVE_INFINITY);

        if (isNull) {
            throw new ApiException(ERROR_CODES.INVALID_PARAM, "Illegal parameter exception.");
        }
    }
}
