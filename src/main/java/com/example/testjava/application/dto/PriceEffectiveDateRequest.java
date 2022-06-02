package com.example.testjava.application.dto;

public class PriceEffectiveDateRequest {

    private static final long serialVersionUID = 1;

    private String effectiveDate;
    private Integer productId;
    private Integer brandId;

    public PriceEffectiveDateRequest(String effectiveDate, Integer productId, Integer brandId) {
        //this.effectiveDate = LocalDateTimeParser.parse(effectiveDate);
        this.effectiveDate = effectiveDate;
        this.productId = productId;
        this.brandId = brandId;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

}
