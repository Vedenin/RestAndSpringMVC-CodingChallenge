package com.github.vedenin.codingchallenge;

import com.github.vedenin.codingchallenge.mvc.model.CountryService;
import com.github.vedenin.codingchallenge.mvc.model.CountryServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by slava on 12.02.17.
 */
public class CountryServiceTest {
    @Test
    public void testService() {
        CountryService countryService = new CountryServiceImpl();
        List<String> lists = countryService.getCountriesNames();
        Assert.assertNotNull(lists);
        Assert.assertTrue(lists.size() > 0);
     }
}
