package com.example.testjava.application.service;

import com.example.testjava.application.dto.PriceEffectiveDateRequest;

public interface PriceService {
    public Object getApplyTariff(PriceEffectiveDateRequest requestDto);
}
