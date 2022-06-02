package com.example.testjava.application.service.impl;

import com.example.testjava.application.dto.PriceEffectiveDateRequest;
import com.example.testjava.application.repository.PriceRepository;
import com.example.testjava.application.service.PriceService;
import com.example.testjava.domain.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Override
    public Object getApplyTariff(PriceEffectiveDateRequest requestDto) {
        List<Price> priceList = priceRepository.findAllByEffectiveDate(requestDto.getEffectiveDate(),
            requestDto.getBrandId(), requestDto.getProductId());
        return priceList.size() > 0 ? priceList.get(0).toMapObject() : "result-set-is-empty";
    }
}
