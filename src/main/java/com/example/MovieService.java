package com.example;

import io.micronaut.context.annotation.Bean;
import java.util.List;

@Bean
public class MovieService {


  private final MovieGateway movieGateway;

  public MovieService(com.example.MovieGateway movieGateway) {
    this.movieGateway = movieGateway;
  }

  List<Movie> search(String name) {
    return movieGateway.search(name).getMovies();
  }

  public MovieDetail get(int id) {
    return movieGateway.getById(id);
  }
}
