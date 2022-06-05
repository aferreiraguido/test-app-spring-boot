package com.example.testjava.infrastructure.webservice;

import com.example.testjava.application.dto.PriceEffectiveDateRequest;
import com.example.testjava.application.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/price")
public class PriceApi {
    @Autowired
    PriceService priceService;

    /**
     * Servicio que devuelve un identificador de producto, identificador de cadena,
     * tarifa a aplicar, las fechas de aplicación y precio final a aplicar; dada una
     * fecha aplicación, un identificador de producto y un identificador de cadena.
     *
     * @param  effectiveDate    fecha aplicación
     * @param  productId        identificador de producto
     * @param  brandId          identificador de cadena
     * @return                  json que describe el registro buscado o un identificador de error
     *                          siempre retorna status 200 OK manejando de forma interna el error
     *                          de logica de aplicacion
     */
    @GetMapping(value = "/byEffectiveDate", produces = { "application/json" })
    public ResponseEntity<Object> getByEffectiveDate(@RequestParam(required = true) String effectiveDate,
                                                     @RequestParam(required = true) Integer productId,
                                                     @RequestParam(required = true) Integer brandId) {
        PriceEffectiveDateRequest effectiveRequest = new PriceEffectiveDateRequest(effectiveDate, productId, brandId);
        Object response = priceService.getApplyTariff(effectiveRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
