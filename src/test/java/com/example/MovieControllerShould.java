package com.example;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class MovieControllerShould {

  @Test
  @DisplayName("movie controller should call service")
  public void movie_controller_should_call_service() {
    // arrange
    MovieService movieService = mock(MovieService.class);
    MovieController movieController = new MovieController(movieService);
    Movie movie = new Movie(1,",","",2.4f,2,"");
    given(movieService.search("name")).willReturn(Flux.fromIterable( List.of( movie)));
    // act
    movieController.search("name");

    // assert
    verify(movieService).search("name");

  }

  @Test
  @DisplayName("get by id should call service")
  public void get_by_id_should_call_service() {
    // arrange
    MovieService movieService = mock(MovieService.class);
    MovieController movieController = new MovieController(movieService);

    // act
    movieController.get(1);

    // assert
    verify(movieService).get(1);
  }

}
