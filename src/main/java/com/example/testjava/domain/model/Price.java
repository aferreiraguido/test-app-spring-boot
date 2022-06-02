package com.example.testjava.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "PRICE")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "BRAND_ID")
    private Integer brandId;
    @Column(name = "START_DATE")
    private String startDate;
    @Column(name = "END_DATE")
    private String  endDate;
    @Column(name = "PRICE_LIST")
    private Integer priceList;
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Column(name = "PRIORITY")
    private Integer priority;
    @Column(name = "PRICE")
    private Double  price;
    @Column(name = "CURR")
    private String currency;

    public Object toMapObject() {
        Map<String, String> priceMap = new HashMap<String, String>();
        priceMap.put("productId", String.valueOf(productId));
        priceMap.put("brandId", String.valueOf(brandId));
        priceMap.put("productId", String.valueOf(productId));
        priceMap.put("startDate", startDate);
        priceMap.put("endDate", endDate);
        priceMap.put("price", String.valueOf(price));
        return priceMap;
    }
}
