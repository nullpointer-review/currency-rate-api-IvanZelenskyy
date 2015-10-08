package com.example;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CurrencyRatesTest {

	CurrencyRates rates;
	
	@Before
	public void Init(){
		rates = new CurrencyRates();
	}
	
	@Test
	public void testGetCurrencyRatebyCodeIfListIsNull() {
		rates.setList(null);
		assertNull(rates.getCurrencyRatebyCode("USD"));
	}
	
	@Test
	public void testGetCurrencyRatebyCodeIfListIsEmpty() {
		rates.setList(new ArrayList<>());
		assertNull(rates.getCurrencyRatebyCode("USD"));
	}

	@Test
	public void testGetCurrencyRatebyCodeIfListHasElement() {
		rates.setList(new ArrayList<>());
		CurrencyRate usd = new CurrencyRate("USD", "65.00", "2015-10-08");
		CurrencyRate uah = new CurrencyRate("UAH", "3.1", "2015-10-08");
		rates.getList().add(usd);
		rates.getList().add(uah);
		assertEquals(usd, rates.getCurrencyRatebyCode("USD"));
		assertEquals(uah, rates.getCurrencyRatebyCode("UAH"));
	}
	
	@Test
	public void testGetCurrencyRatebyCodeIfListHasNoElement() {
		rates.setList(new ArrayList<>());
		CurrencyRate usd = new CurrencyRate("USD", "65.00", "2015-10-08");
		CurrencyRate uah = new CurrencyRate("UAH", "3.1", "2015-10-08");
		rates.getList().add(usd);
		rates.getList().add(uah);
		assertNull(rates.getCurrencyRatebyCode("EUR"));		
	}
}
