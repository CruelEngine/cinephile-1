package com.example;

import io.micronaut.context.annotation.Bean;
import java.util.List;
import reactor.core.publisher.Flux;

@Bean
public class MovieService {


  private final MovieGateway movieGateway;

  public MovieService(com.example.MovieGateway movieGateway) {
    this.movieGateway = movieGateway;
  }

  Flux<Movie> search(String name) {
    return movieGateway
        .search(name)
        .map(TmdbResponse::getMovies)
        .flatMapMany(Flux::fromIterable);
  }

  public MovieDetail get(int id) {
    return movieGateway.getById(id);
  }
}
