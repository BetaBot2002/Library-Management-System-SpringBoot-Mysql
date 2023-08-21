package com.lms.librarymanagementsystem.Handlers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHandler {
    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now(); // get current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // create formatter for MySQL format
        String mysqlDate = currentDate.format(formatter); // format current date as MySQL string
        return mysqlDate;
    }

    public static String addOneYearToDate(String mysqlDateStr) {
        // Create a DateTimeFormatter for MySQL date format (yyyy-MM-dd)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Parse the input string into a LocalDate object
        LocalDate date = LocalDate.parse(mysqlDateStr, formatter);
        
        // Add one year to the date
        LocalDate oneYearLater = date.plusYears(1);
        
        // Format the new date as a string in MySQL date format
        String oneYearLaterStr = oneYearLater.format(formatter);
        
        // Return the new date string
        return oneYearLaterStr;
      }

      public static String getDateTimePattern() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime+"_";
    }
}
