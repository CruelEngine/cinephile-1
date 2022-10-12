package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TmdbResponse {

  public int getPage() {
    return page;
  }

  private final int page;
  private final List<Movie> movies;

  public TmdbResponse( @JsonProperty("page") int page, @JsonProperty("results") List<Movie> movies) {
    this.page = page;
    this.movies = movies;
  }

  public List<Movie> getMovies() {
    return this.movies;

  }
}
