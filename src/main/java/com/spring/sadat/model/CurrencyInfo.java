package com.spring.sadat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "CurrencyInfo")
public class CurrencyInfo {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "currencyId")
    private long currencyId;

    @Id
	@Column(name = "country")
    private String country;

    @Column(name = "currencyPrice")
    private String currencyPrice;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Generated(GenerationTime.ALWAYS) 
	@Column(name="lastUpdatedDate", insertable=false,updatable=false)
    private Date lastUpdatedDate;

	public long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrencyPrice() {
		return currencyPrice;
	}

	public void setCurrencyPrice(String currencyPrice) {
		this.currencyPrice = currencyPrice;
	}

}
