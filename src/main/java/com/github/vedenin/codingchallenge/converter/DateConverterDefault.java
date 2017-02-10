package com.github.vedenin.codingchallenge.converter;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by vvedenin on 2/10/2017.
 */
@Service
public class DateConverterDefault implements DateConverter {
    @Override
    public Calendar getCalendarFromString(String dateString) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
