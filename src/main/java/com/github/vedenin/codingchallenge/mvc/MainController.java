package com.github.vedenin.codingchallenge.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.vedenin.codingchallenge.restclient.enums.CurrencyEnum;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * Created by slava on 05.02.17.
 */
public class MainController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView("CurrencyConverter");
        model.addObject("currencyEnum", CurrencyEnum.values());
        model.addObject("defaultCurrencyTo", CurrencyEnum.EUR);
        model.addObject("defaultCurrencyFrom", CurrencyEnum.USD);

        return model;
    }
}
