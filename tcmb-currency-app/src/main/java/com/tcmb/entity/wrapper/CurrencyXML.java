package com.tcmb.entity.wrapper;


import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Currency")
@ToString
@Getter
public class CurrencyXML {

    @XmlAttribute(name = "CurrencyCode")
    private String currencyCode;

    @XmlElement(name = "CurrencyName")
    private String currencyName;

    @XmlElement(name = "ForexBuying")
    private double forexBuying;

    @XmlElement(name = "ForexSelling")
    private double forexSelling;

    @XmlElement(name = "BanknoteBuying")
    private double banknoteBuying;

    @XmlElement(name = "BanknoteSelling")
    private double banknoteSelling;
}



