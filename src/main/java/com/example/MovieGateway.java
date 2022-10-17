package com.example;

import io.micronaut.context.annotation.Bean;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.reactor.http.client.ReactorHttpClient;
import jakarta.inject.Inject;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import reactor.core.publisher.Mono;

@Bean
public class MovieGateway {

  @Inject
  @Client("https://api.themoviedb.org/3/")
  ReactorHttpClient client;

  public Mono<TmdbResponse> search(String name) {
    return client
        .retrieve(HttpRequest.GET(
                "search/movie?api_key=e470560acfb347655d8af373c29aba11&query=" + URLEncoder.encode(name,
                    StandardCharsets.UTF_8)
            ),
            TmdbResponse.class).singleOrEmpty();
  }

  public MovieDetail getById(int id) {
    var uri = "movie/" + id + "?api_key=e470560acfb347655d8af373c29aba11";
    System.out.println(uri);
    return client.toBlocking()
        .retrieve(HttpRequest.GET(uri),
            MovieDetail.class);
  }
}
