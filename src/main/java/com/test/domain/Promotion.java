package com.test.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="promotion")
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Promotion {
	
	@Id
	@Column(name="promotion_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int promotionId;
	
	private String name;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\npromotionID:").append(promotionId).
		append("\nname:").append(name);
		
		return sb.toString();
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
