package com.bia.web.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(
    origins = "http://localhost:8080",
    allowCredentials = "true",
    allowedHeaders = "*",
    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.OPTIONS,RequestMethod.HEAD}
)
public class CorsBase {

}
