package com.example;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@MicronautTest
public class MovieControllerTest {

  @Inject
  @Client("/movies")
  HttpClient client;

  @Test
  @DisplayName("test that movies search works")
  public void test_that_movies_search_works() {
    List<Movie> movies = client.toBlocking()
        .retrieve(HttpRequest.GET("search?query=top%20gun"), Argument.listOf(Movie.class));
    assertThat(movies).isNotNull();
    assertThat(movies.get(0)).isNotNull();
    Movie movie = movies.get(0);
    assertThat(movie.getImage()).isEqualTo("/62HCnUTziyWcpDaBO2i1DX17ljH.jpg");
    assertThat(movie.getName()).isEqualTo("Top Gun: Maverick");

    assertThat(movie.getVoteAverage()).isGreaterThan(0f);
    assertThat(movie.getVoteCount()).isGreaterThan(0);
    assertThat(movie.getReleaseDate()).isEqualTo("2022-05-24");
    assertThat(movie.getId()).isEqualTo(361743);
  }

  @Test
  @DisplayName("get by id works")
  public void get_by_id_works() {
    MovieDetail movieDetail = client.toBlocking()
        .retrieve(HttpRequest.GET("361743"), MovieDetail.class);
    assertThat(movieDetail).isNotNull();
    assertThat(movieDetail.getBackdropPath()).isEqualTo("/odJ4hx6g6vBt4lBWKFD1tI8WS4x.jpg");
    assertThat(movieDetail.getOriginalLanguage()).isEqualTo("en");
    assertThat(movieDetail.getDuration()).isEqualTo(131);
    assertThat(movieDetail.getOverview()).startsWith(
        "After more than thirty years of service as one of the Navy");


  }
}
