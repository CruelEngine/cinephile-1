package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/cinephile")
public class CinephileController {


  @Inject
  GreeterService greeterService;

  @Get(uri = "/people/{person}", produces = "application/json")
  public Response index(String person) {
    return greeterService.greete(person);
  }
}