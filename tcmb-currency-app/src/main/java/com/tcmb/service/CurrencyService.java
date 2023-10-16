package com.tcmb.service;


import com.tcmb.entity.Currency;
import com.tcmb.entity.response.Response;

import java.util.List;

public interface CurrencyService {

    Response getCurrencyListByDate(String strDate);

    Currency save(Currency currency);

}
