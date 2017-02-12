package com.github.vedenin.codingchallenge.mvc.model;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by slava on 12.02.17.
 */
@Service
public class CountryServiceImpl implements CountryService {
    @Override
    public List<String> getCountriesNames() {
        return Arrays.stream(Locale.getISOCountries()).
                map((code)->new Locale("en", code)).
                map(Locale::getDisplayCountry).
                sorted().
                collect(Collectors.toList());
    }
}
