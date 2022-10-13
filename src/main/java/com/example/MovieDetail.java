package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDetail {


  private String originalLanguage;
  private int duration;
  private String overview;
  private String backdropPath;

  public MovieDetail( @JsonProperty("backdrop_path") String backDropPath, @JsonProperty("original_language") String originalLanguage, @JsonProperty("runtime") int duration, @JsonProperty("overview") String overview) {
    this.backdropPath = backDropPath;
    this.originalLanguage = originalLanguage;
    this.duration = duration;
    this.overview = overview;
  }

 

  public String getOriginalLanguage() {
    return originalLanguage;
  }

  public int getDuration() {
    return duration;
  }

  public String getOverview() {
    return overview;
  }

  public String getBackdropPath() {
    return backdropPath;
  }
}
