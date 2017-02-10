package com.github.vedenin.codingchallenge.converter;

import java.util.Calendar;

/**
 * Created by vvedenin on 2/10/2017.
 */
public interface DateConverter {
    Calendar getCalendarFromString(String date);
}
