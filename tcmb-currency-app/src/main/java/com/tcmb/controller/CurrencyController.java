package com.tcmb.controller;

import com.tcmb.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api")
public class CurrencyController {

    private final CurrencyService currencyService;


    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/{date}")
    public ResponseEntity<?> getCurrencyListByDate(@PathVariable("date") String date){
        return ResponseEntity.ok(currencyService.getCurrencyListByDate(date));
    }



}
