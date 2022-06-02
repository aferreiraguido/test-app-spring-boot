package com.example.testjava.application.repository;

import com.example.testjava.domain.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Integer> {

    @Query(value = "FROM Price WHERE startDate <= :effectiveDate AND :effectiveDate <= endDate AND brandId = :brandId AND productId = :productId ORDER BY priceList DESC")
    public List<Price> findAllByEffectiveDate(@Param("effectiveDate") String effectiveDate,
                                                    @Param("brandId") Integer brandId,
                                                    @Param("productId") Integer productId);

}
