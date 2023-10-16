package com.tcmb.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Data
@Setter
@Getter
@ToString
@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String currencyCode;

    private String currencyName;

    private Double forexBuying;

    private Double forexSelling;

    private Double banknoteBuying;

    private Double banknoteSelling;
}
