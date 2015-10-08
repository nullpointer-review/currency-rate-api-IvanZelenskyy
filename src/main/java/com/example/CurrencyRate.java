package com.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Model class for currency data.
 * Has String fields: code, rate, date.
 * Fields code and rate could be parsed by unmarshalling xml from rest-services of Central Bank of Russia.
 */
@XmlRootElement(name="Valute")
public class CurrencyRate {

	String code;
	String rate;
	String date;

	public CurrencyRate() {
		super();
	}	
	
	public CurrencyRate(String code, String rate, String date) {
		super();
		this.code = code;
		this.rate = rate;
		this.date = date;
	}
	
	public String getCode() {
		return code;
	}
	
	@XmlElement(name="CharCode")
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public String getRate() {
		return rate;
	}
	
	@XmlElement(name="Value")
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
