package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currency/api/rate")
public class RateRestController {

	@RequestMapping(value="{code}/{date}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public CurrencyRate getRate(@PathVariable("code") String code, @PathVariable("date") String dateStr){
		LocalDate date = LocalDate.parse(dateStr);
		return getRateFromCbrRest(code, date);
	}
	
	@RequestMapping(value="{code}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public CurrencyRate getRate(@PathVariable("code") String code){
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		return getRateFromCbrRest(code, tomorrow);
	}
	
	private CurrencyRate getRateFromCbrRest(String code, LocalDate date){
		DateTimeFormatter cbrDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String urlCbr = "http://www.cbr.ru/scripts/XML_daily.asp?date_req="+date.format(cbrDateFormatter);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new Jaxb2RootElementHttpMessageConverter());
		CurrencyRates rates = restTemplate.getForObject(urlCbr, CurrencyRates.class);
		CurrencyRate result = rates.getCurrencyRatebyCode(code);
		if(result==null) return null;
		result.setDate(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		return result;
	}
}
