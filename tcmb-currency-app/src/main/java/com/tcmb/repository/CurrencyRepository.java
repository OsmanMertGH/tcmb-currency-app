package com.tcmb.repository;

import com.tcmb.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {

    List<Currency> findCurrencyByDate(String date);

}
