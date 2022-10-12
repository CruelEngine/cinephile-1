package com.example;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovieControllerShould {

  @Test
  @DisplayName("movie controller should call service")
  public void movie_controller_should_call_service() {
    // arrange
    MovieService movieService = mock(MovieService.class);
    MovieController movieController = new MovieController(movieService);

    // act
    movieController.search("name");


    // assert
    verify(movieService).search("name");

  }

}
