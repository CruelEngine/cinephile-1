package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import java.util.List;

@Controller("movies")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @Get(uri = "search")
  public List<Movie> search( @QueryValue String query) {
    return movieService.search(query);
  }

  @Get("/{id}")
  public MovieDetail get(int id) {
    return movieService.get(id);
  }
}
