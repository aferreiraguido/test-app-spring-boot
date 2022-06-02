package com.example.testjava.application;

import java.time.LocalDateTime;

public class LocalDateTimeParser {

    public static LocalDateTime parse(String effectiveDate) {

        try {
            String[] dateComponents = effectiveDate.split("-");
            Integer year = Integer.parseInt(dateComponents[0]);
            Integer month = Integer.parseInt(dateComponents[1]);
            Integer day = Integer.parseInt(dateComponents[2]);

            String[] hourComponents = dateComponents[3].split("\\.");
            Integer hour = Integer.parseInt(hourComponents[0]);
            Integer minute = Integer.parseInt(hourComponents[1]);
            Integer second = Integer.parseInt(hourComponents[2]);

            return LocalDateTime.of(year, month, day, hour, minute, second);
        } catch (Exception e) {
        }

        return LocalDateTime.now();
    }
}
