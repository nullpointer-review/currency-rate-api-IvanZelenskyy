package com.example;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Model class for root element in XML provided by Central Bank.
 * Stores a list of CurrencyRate.
 * Also has getCurrencyRatebyCode method to search element in this list.
 */
@XmlRootElement(name="ValCurs")
public class CurrencyRates {
	List<CurrencyRate> list;

	String datestr;
	
	public List<CurrencyRate> getList() {
		return list;
	}

	@XmlElement(name="Valute")
	public void setList(List<CurrencyRate> list) {
		this.list = list;
	}
	
	/**
	 * Does linear search in this.list by CurrencyRate.code field.
	 * @param code
	 * @return CurrencyRate or null if not found or if list is null or empty.
	 */
	public CurrencyRate getCurrencyRatebyCode(String code){
		if(this.list==null || this.list.isEmpty()) return null;
		for(CurrencyRate cr : this.list)
			if(code.equalsIgnoreCase(cr.code)) return cr;
		return null;
	}

	public String getDatestr() {
		return datestr;
	}

	@XmlAttribute(name="Date")
	public void setDatestr(String datestr) {
		this.datestr = datestr;
	}
}
