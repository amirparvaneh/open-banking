package com.rest.open.openbanking.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "api-service")
public interface ServiceProxy extends ServiceCard {

 }
