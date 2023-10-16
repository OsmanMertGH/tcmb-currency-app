package com.tcmb.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Data
@Setter
@Getter
@ToString
public class TarihDate {

    private String Tarih;

    private String Date;

    private String BultenNo;

    private List<Currency> CurrencyList;
}
