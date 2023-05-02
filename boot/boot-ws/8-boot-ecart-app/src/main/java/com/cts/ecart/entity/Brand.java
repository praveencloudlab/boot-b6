package com.cts.ecart.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "brands")
public class Brand {

	@Id
	private int brandId;
	private String brandTitle;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "brand_info", joinColumns = { @JoinColumn(name = "brand_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private List<Product> prods = new ArrayList<>();

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandTitle() {
		return brandTitle;
	}

	public void setBrandTitle(String brandTitle) {
		this.brandTitle = brandTitle;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandTitle=" + brandTitle + ", prods=" + prods + "]";
	}

}
