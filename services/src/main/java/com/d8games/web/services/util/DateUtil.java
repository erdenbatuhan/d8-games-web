package com.d8games.web.services.util;

import java.util.*;

public class DateUtil {

    public enum DateKey {

        WEEK_DAY (0), MONTH (1), DAY (2), HOUR (3), YEAR (5), H (0), M (1), S (2);

        private final int key;

        DateKey(int key) {
            this.key = key;
        }
    }

    private Date actualDate;
    private String date;
    private String day;
    private String hour;

    public static void main(String[] args) {
        new DateUtil();
    }

    public DateUtil() {
        this.actualDate = new Date();
        parseDate();
    }

    private void parseDate() {
        List<String> dateParts = getDateParts();

        String hour = dateParts.get(DateKey.HOUR.key);
        List<String> hourParts = getHourParts(hour);

        setDate(hourParts.get(0), hourParts.get(1));
    }

    private List<String> getDateParts() {
        List<String> dateParts = getStringTokenized(this.actualDate.toString(), " ");

        String weekDay = dateParts.get(DateKey.WEEK_DAY.key);
        String month = dateParts.get(DateKey.MONTH.key);
        String day = dateParts.get(DateKey.DAY.key);
        String year = dateParts.get(DateKey.YEAR.key);

        this.date = day + " " + month + " " + year;
        this.day = weekDay;

        return dateParts;
    }

    private List<String> getHourParts(String hour) {
        List<String> hourParts = getStringTokenized(hour, ":");

        int h = Integer.parseInt(hourParts.get(DateKey.H.key));
        int m = Integer.parseInt(hourParts.get(DateKey.M.key));
        int s = Integer.parseInt(hourParts.get(DateKey.S.key));

        hourParts.remove(hourParts.get(DateKey.S.key));

        // 2nd half of the minute is rounded up
        if (s >= 30) { m += 1; }

        if (0 <= m && m < 15) { m = 0; }
        else if (15 <= m && m < 45) { m = 30; }
        else { m = 0; h += 1; }

        hourParts = new ArrayList<>();

        hourParts.add(String.valueOf(h));
        hourParts.add(String.valueOf(m));

        for (int i = 0; i < hourParts.size(); i++)
            if (hourParts.get(i).length() < 2)
                hourParts.set(i, "0" + hourParts.get(i));

        this.hour = hourParts.get(0) + ":" + hourParts.get(1);
        return hourParts;
    }

    private List<String> getStringTokenized(String stringToTokenize, String tokenizerKey) {
        List<String> stringTokenized = new ArrayList<>();
        stringToTokenize += tokenizerKey;

        int lh = 0, rh;
        while ((rh = stringToTokenize.indexOf(tokenizerKey, lh)) >= 0) {
            stringTokenized.add(stringToTokenize.substring(lh, rh));
            lh = rh + 1;
        }

        return stringTokenized;
    }

    private void setDate(String hour, String minute) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
        calendar.set(Calendar.MINUTE, Integer.parseInt(minute));
        calendar.set(Calendar.SECOND, 0);

        this.actualDate = calendar.getTime();
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
