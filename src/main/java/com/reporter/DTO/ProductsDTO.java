package com.reporter.DTO;

import com.opencsv.bean.CsvBindByName;

public class ProductsDTO {

	
	@CsvBindByName(column = "product_id", required=true)
	private int productId;

	@CsvBindByName(column = "product_name" ,required=true)
	private String productName;
	
	 @CsvBindByName(column="productBarcodeNumber",required=true)
	    private int productBarcodeNumber;

	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductBarcodeNumber() {
		return productBarcodeNumber;
	}

	public void setProductBarcodeNumber(int productBarcodeNumber) {
		this.productBarcodeNumber = productBarcodeNumber;
	}
	

	 
	 
	 
	
}
