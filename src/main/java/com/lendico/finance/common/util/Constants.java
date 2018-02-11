package com.lendico.finance.common.util;

public class Constants {
    public static int DAYS_OF_MONTH = 30;
    public static int DAYS_IN_YEAR = 360;
    public static int MONTHS_IN_YEAR = 12;
    public static int PERCENTILE = 100;
    public static double LAST_REMAINING_OUTSTANDING = 0.00;
    public static String CLIENT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static String CLIENT_NUMBER_FORMAT = ".##";


    public enum ERROR_CODES {
        RUNTIME(1),
        IO(2),
        INVALID_PARAM(3),
        PARSER(4);

        private final int value;

        ERROR_CODES(int i) {
            this.value = i;
        }

        public int value() {
            return value;
        }
    }
}
