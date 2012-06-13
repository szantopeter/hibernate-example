package com.test.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

@Entity
@NamedQuery(name="Site.readSiteCode", query="SELECT s FROM Site s WHERE s.siteCode = :siteCode")
@Table(name="site")
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Site {
	
	//@Version
	//private int version;
	
	@Id
	@Column(name="site_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int siteId;
	
	@Column(name="login_time_limit")
	private int loginTimeLimit;
	
	@Column(name="country_code", length=3)
	private String countryCode;

	@Column(name="language_code", length=3)
	private String languageCode;

	@Column(name="brand_code", length=3)
	private String brandCode;

	@Column(insertable=false, updatable=false, unique=true)
	@Formula("concat(country_code, '.', language_code, '.', brand_code)")
	private String siteCode;
	
	@OneToOne
	@JoinColumn(name="default_promotion_id")
	private Promotion defaultPromotion;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nsiteID:" + siteId)
		.append("\nloginTimeLimit:").append(loginTimeLimit)
		.append("\ncountryCode:").append(countryCode)
		.append("\nsiteCode:").append(siteCode)
		.append("\n\tdefault promotion:").append(getDefaultPromotion());
		
		return sb.toString();
	}
	
	public int getSiteId() {
		return siteId;
	}
	protected void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	protected void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setLoginTimeLimit(int loginTimeLimit) {
		this.loginTimeLimit = loginTimeLimit;
	}

	public int getLoginTimeLimit() {
		return loginTimeLimit;
	}

	public void setDefaultPromotion(Promotion defaultPromotion) {
		this.defaultPromotion = defaultPromotion;
	}

	public Promotion getDefaultPromotion() {
		return defaultPromotion;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

}

