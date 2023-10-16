package com.tcmb.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcmb.entity.Currency;
import com.tcmb.entity.TarihDate;
import com.tcmb.entity.response.Response;
import com.tcmb.entity.wrapper.TarihDateXML;
import com.tcmb.repository.CurrencyRepository;
import com.tcmb.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.List;


@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final RestTemplate restTemplate;
    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(RestTemplate restTemplate, CurrencyRepository currencyRepository) {
        this.restTemplate = restTemplate;
        this.currencyRepository = currencyRepository;
    }

    public Response getCurrencyListByDate(String strDate) {

        Response response = new Response();

        List<Currency> currencies = currencyRepository.findCurrencyByDate(strDate);

        if (currencies != null && !currencies.isEmpty()) {
            response.setResult(currencies);
            return response;
        }
        LocalDate date = LocalDate.parse(strDate);

        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        String formattedDay = (day < 10) ? "0" + day : String.valueOf(day);
        String formattedMonth = (month < 10) ? "0" + month : String.valueOf(month);

        try {
            final String TCMB_XML_URL = "https://www.tcmb.gov.tr/kurlar/" + year + formattedMonth + "/" + formattedDay + formattedMonth + year + ".xml";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_XML);
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(TCMB_XML_URL, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                String xmlData = responseEntity.getBody();
                JAXBContext jaxbContext = JAXBContext.newInstance(TarihDateXML.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                assert xmlData != null;
                TarihDateXML tarihDate = (TarihDateXML) unmarshaller.unmarshal(new StringReader(xmlData));
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(tarihDate);
                TarihDate tarihDateJSON = objectMapper.readValue(json, TarihDate.class);
                response.setResult(tarihDateJSON.getCurrencyList());

                for (Currency currency : tarihDateJSON.getCurrencyList()) {
                    currency.setDate(strDate);
                    save(currency);
                }


            } else {
                response.setResultMessage("Resmi tatil, hafta sonu ve yarım iş günü çalısılan günlerde gösterge niteliginde kur bilgisi yayımlanmamaktadır.");
            }
        } catch (Exception e) {
            response.setErrorMessage(e.getLocalizedMessage());
            response.setResultMessage("Resmi tatil, hafta sonu ve yarım iş günü çalısılan günlerde gösterge niteliginde kur bilgisi yayımlanmamaktadır.");
        }

        return response;
    }

    @Override
    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }
}
