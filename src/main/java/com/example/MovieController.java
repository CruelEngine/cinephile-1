package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import java.util.List;
import reactor.core.publisher.Flux;

@Controller("movies")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @Get(uri = "search")
  public Flux<Movie> search( @QueryValue String query) {
    return movieService.search(query);
  }

  @Get("/{id}")
  public MovieDetail get(int id) {
    return movieService.get(id);
  }
}
