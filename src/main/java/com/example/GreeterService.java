package com.example;

import io.micronaut.context.annotation.Bean;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;

@Bean
public class GreeterService {

  @Inject
  @Client("https://jsonplaceholder.typicode.com/users/")
  HttpClient httpClient;

  Response greete(String person) {
    Person personResponse =
        httpClient.toBlocking().retrieve(HttpRequest.GET("/1"), Person.class);
    Response response = new Response(personResponse.getName(), "hello " + person);
    return response;
  }
}
