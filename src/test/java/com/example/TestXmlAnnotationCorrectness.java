package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.StringReader;
import java.net.MalformedURLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class TestXmlAnnotationCorrectness {
	
	@Test
	public void test() throws JAXBException, MalformedURLException {
		JAXBContext jaxbContext = JAXBContext.newInstance( CurrencyRates.class );
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        CurrencyRates rates = (CurrencyRates)jaxbUnmarshaller.unmarshal(reader);
        assertNotNull(rates);
        assertNotNull(rates.getList());
        assertFalse(rates.list.isEmpty());
        assertEquals(33, rates.list.size());
        CurrencyRate usd = rates.getCurrencyRatebyCode("USD");
        assertNotNull(usd);
	}

	
	private String xml = "<?xml version=\"1.0\" encoding=\"windows-1251\" ?>\n" + 
			"<ValCurs Date=\"03.10.2015\" name=\"Foreign Currency Market\">\n" + 
			"<Valute ID=\"R01010\">\n" + 
			"	<NumCode>036</NumCode>\n" + 
			"	<CharCode>AUD</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Австралийский доллар</Name>\n" + 
			"	<Value>46,4030</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01020A\">\n" + 
			"	<NumCode>944</NumCode>\n" + 
			"	<CharCode>AZN</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Азербайджанский манат</Name>\n" + 
			"	<Value>62,9032</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01035\">\n" + 
			"	<NumCode>826</NumCode>\n" + 
			"	<CharCode>GBP</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Фунт стерлингов Соединенного королевства</Name>\n" + 
			"	<Value>99,8748</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01060\">\n" + 
			"	<NumCode>051</NumCode>\n" + 
			"	<CharCode>AMD</CharCode>\n" + 
			"	<Nominal>100</Nominal>\n" + 
			"	<Name>Армянских драмов</Name>\n" + 
			"	<Value>13,8970</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01090\">\n" + 
			"	<NumCode>974</NumCode>\n" + 
			"	<CharCode>BYR</CharCode>\n" + 
			"	<Nominal>10000</Nominal>\n" + 
			"	<Name>Белорусских рублей</Name>\n" + 
			"	<Value>37,2445</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01100\">\n" + 
			"	<NumCode>975</NumCode>\n" + 
			"	<CharCode>BGN</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Болгарский лев</Name>\n" + 
			"	<Value>37,6507</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01115\">\n" + 
			"	<NumCode>986</NumCode>\n" + 
			"	<CharCode>BRL</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Бразильский реал</Name>\n" + 
			"	<Value>16,4578</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01135\">\n" + 
			"	<NumCode>348</NumCode>\n" + 
			"	<CharCode>HUF</CharCode>\n" + 
			"	<Nominal>100</Nominal>\n" + 
			"	<Name>Венгерских форинтов</Name>\n" + 
			"	<Value>23,5270</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01215\">\n" + 
			"	<NumCode>208</NumCode>\n" + 
			"	<CharCode>DKK</CharCode>\n" + 
			"	<Nominal>10</Nominal>\n" + 
			"	<Name>Датских крон</Name>\n" + 
			"	<Value>98,7147</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01235\">\n" + 
			"	<NumCode>840</NumCode>\n" + 
			"	<CharCode>USD</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Доллар США</Name>\n" + 
			"	<Value>65,9414</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01239\">\n" + 
			"	<NumCode>978</NumCode>\n" + 
			"	<CharCode>EUR</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Евро</Name>\n" + 
			"	<Value>73,6302</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01270\">\n" + 
			"	<NumCode>356</NumCode>\n" + 
			"	<CharCode>INR</CharCode>\n" + 
			"	<Nominal>10</Nominal>\n" + 
			"	<Name>Индийских рупий</Name>\n" + 
			"	<Value>10,0505</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01335\">\n" + 
			"	<NumCode>398</NumCode>\n" + 
			"	<CharCode>KZT</CharCode>\n" + 
			"	<Nominal>100</Nominal>\n" + 
			"	<Name>Казахстанских тенге</Name>\n" + 
			"	<Value>24,3227</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01350\">\n" + 
			"	<NumCode>124</NumCode>\n" + 
			"	<CharCode>CAD</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Канадский доллар</Name>\n" + 
			"	<Value>49,8235</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01370\">\n" + 
			"	<NumCode>417</NumCode>\n" + 
			"	<CharCode>KGS</CharCode>\n" + 
			"	<Nominal>100</Nominal>\n" + 
			"	<Name>Киргизских сомов</Name>\n" + 
			"	<Value>95,7557</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01375\">\n" + 
			"	<NumCode>156</NumCode>\n" + 
			"	<CharCode>CNY</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Китайский юань</Name>\n" + 
			"	<Value>10,3745</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01500\">\n" + 
			"	<NumCode>498</NumCode>\n" + 
			"	<CharCode>MDL</CharCode>\n" + 
			"	<Nominal>10</Nominal>\n" + 
			"	<Name>Молдавских леев</Name>\n" + 
			"	<Value>32,7822</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01535\">\n" + 
			"	<NumCode>578</NumCode>\n" + 
			"	<CharCode>NOK</CharCode>\n" + 
			"	<Nominal>10</Nominal>\n" + 
			"	<Name>Норвежских крон</Name>\n" + 
			"	<Value>77,9643</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01565\">\n" + 
			"	<NumCode>985</NumCode>\n" + 
			"	<CharCode>PLN</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Польский злотый</Name>\n" + 
			"	<Value>17,3448</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01585F\">\n" + 
			"	<NumCode>946</NumCode>\n" + 
			"	<CharCode>RON</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Румынский лей</Name>\n" + 
			"	<Value>16,6801</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01589\">\n" + 
			"	<NumCode>960</NumCode>\n" + 
			"	<CharCode>XDR</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>СДР (специальные права заимствования)</Name>\n" + 
			"	<Value>92,3384</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01625\">\n" + 
			"	<NumCode>702</NumCode>\n" + 
			"	<CharCode>SGD</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Сингапурский доллар</Name>\n" + 
			"	<Value>46,0003</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01670\">\n" + 
			"	<NumCode>972</NumCode>\n" + 
			"	<CharCode>TJS</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Таджикский сомони</Name>\n" + 
			"	<Value>10,2833</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01700J\">\n" + 
			"	<NumCode>949</NumCode>\n" + 
			"	<CharCode>TRY</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Турецкая лира</Name>\n" + 
			"	<Value>21,7679</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01710A\">\n" + 
			"	<NumCode>934</NumCode>\n" + 
			"	<CharCode>TMT</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Новый туркменский манат</Name>\n" + 
			"	<Value>18,8404</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01717\">\n" + 
			"	<NumCode>860</NumCode>\n" + 
			"	<CharCode>UZS</CharCode>\n" + 
			"	<Nominal>1000</Nominal>\n" + 
			"	<Name>Узбекских сумов</Name>\n" + 
			"	<Value>25,1685</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01720\">\n" + 
			"	<NumCode>980</NumCode>\n" + 
			"	<CharCode>UAH</CharCode>\n" + 
			"	<Nominal>10</Nominal>\n" + 
			"	<Name>Украинских гривен</Name>\n" + 
			"	<Value>31,1853</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01760\">\n" + 
			"	<NumCode>203</NumCode>\n" + 
			"	<CharCode>CZK</CharCode>\n" + 
			"	<Nominal>10</Nominal>\n" + 
			"	<Name>Чешских крон</Name>\n" + 
			"	<Value>27,1096</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01770\">\n" + 
			"	<NumCode>752</NumCode>\n" + 
			"	<CharCode>SEK</CharCode>\n" + 
			"	<Nominal>10</Nominal>\n" + 
			"	<Name>Шведских крон</Name>\n" + 
			"	<Value>78,6018</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01775\">\n" + 
			"	<NumCode>756</NumCode>\n" + 
			"	<CharCode>CHF</CharCode>\n" + 
			"	<Nominal>1</Nominal>\n" + 
			"	<Name>Швейцарский франк</Name>\n" + 
			"	<Value>67,4661</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01810\">\n" + 
			"	<NumCode>710</NumCode>\n" + 
			"	<CharCode>ZAR</CharCode>\n" + 
			"	<Nominal>10</Nominal>\n" + 
			"	<Name>Южноафриканских рэндов</Name>\n" + 
			"	<Value>47,3955</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01815\">\n" + 
			"	<NumCode>410</NumCode>\n" + 
			"	<CharCode>KRW</CharCode>\n" + 
			"	<Nominal>1000</Nominal>\n" + 
			"	<Name>Вон Республики Корея</Name>\n" + 
			"	<Value>55,8154</Value>\n" + 
			"</Valute>\n" + 
			"<Valute ID=\"R01820\">\n" + 
			"	<NumCode>392</NumCode>\n" + 
			"	<CharCode>JPY</CharCode>\n" + 
			"	<Nominal>100</Nominal>\n" + 
			"	<Name>Японских иен</Name>\n" + 
			"	<Value>54,8986</Value>\n" + 
			"</Valute>\n" + 
			"</ValCurs>\n";
}
