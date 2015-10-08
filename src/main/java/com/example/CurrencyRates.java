package com.example;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
