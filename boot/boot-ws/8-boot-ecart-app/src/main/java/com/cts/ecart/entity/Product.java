package com.cts.ecart.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productTitle;
	private String description;
	private String keywords;
	private double rating;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "price_id")
	private Price priceObj;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "stockId")
	private Stock stockData;

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productTitle=" + productTitle + ", description=" + description
				+ ", keywords=" + keywords + ", rating=" + rating + ", priceObj=" + priceObj + ", stockData="
				+ stockData + "]";
	}

}
