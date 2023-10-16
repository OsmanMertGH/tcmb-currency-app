package com.tcmb.entity.wrapper;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@Data
@XmlRootElement(name = "Tarih_Date")
public class TarihDateXML {

    @XmlAttribute(name = "Tarih")
    private String Tarih;

    @XmlAttribute(name = "Date")
    private String Date;

    @XmlAttribute(name = "Bulten_No")
    private String BultenNo;

    @XmlElement(name = "Currency")
    private List<CurrencyXML> CurrencyList;
}



