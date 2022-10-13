package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovieServiceShould {

  @Test
  @DisplayName("movie service should call gateway")
  public void movie_service_should_call_gateway() {
    MovieGateway movieGateway = mock(MovieGateway.class);
    MovieService  movieService = new MovieService(movieGateway);
    Movie movie  = new Movie(1, "name", "image", 9.3f, 234, "2019-1-1");
     List<Movie> movies = List.of(movie);
    TmdbResponse tmdbResponse =   new TmdbResponse(1,movies  );
    given(movieGateway.search("name")).willReturn(tmdbResponse);
    movieService.search("name");
    verify(movieGateway).search("name");
  }

  @Test
  @DisplayName("get by id calls gateway")
  public void get_by_id_calls_gateway() {
    MovieGateway movieGateway = mock(MovieGateway.class);
    MovieService  movieService = new MovieService(movieGateway);
    MovieDetail movieDetail = new MovieDetail("","",0,"");
    given(movieGateway.getById(1)).willReturn(movieDetail);
  }
}