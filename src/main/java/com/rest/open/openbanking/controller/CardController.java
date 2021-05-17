package com.rest.open.openbanking.controller;
import com.rest.open.openbanking.service.ServiceProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableFeignClients(basePackageClasses = ServiceProxy.class)
public class CardController implements ServiceProxy {

    private ServiceProxy proxy;

    public CardController(ServiceProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    @GetMapping(path = "/rest/v2/all")
    public List<Object> getCountries() {
        return proxy.getCountries() ;
    }

    @Override
    @GetMapping(path = "/products")
    public List<Object> getProduct() {
        return proxy.getProduct();
    }
}
