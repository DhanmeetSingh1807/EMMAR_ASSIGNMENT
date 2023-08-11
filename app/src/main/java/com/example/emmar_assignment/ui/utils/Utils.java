package com.example.emmar_assignment.ui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getDate(String _date) {
        String timestamp = _date;
        SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss 'GMT'Z yyyy");
        SimpleDateFormat outputFormat1 = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
        SimpleDateFormat outputFormat2 = new SimpleDateFormat("MMM dd, yyyy");

        try {
            Date date = inputFormat.parse(timestamp);
            String todayTime = outputFormat1.format(date);
            String yesterdayTime = outputFormat1.format(new Date(date.getTime() - 2 * 24 * 60 * 60 * 1000));
            String twoDaysAgo = "2 days ago";
            String monthDateYear = outputFormat2.format(date);
            System.out.println("Today, time(hour:minute): " + todayTime);
            System.out.println("Yesterday, hour:minute: " + yesterdayTime);
            System.out.println("2 days ago: " + twoDaysAgo);
            System.out.println("Month date, year: " + monthDateYear);
            return monthDateYear;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
