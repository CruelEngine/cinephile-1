package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

  private String names;
  private String image;
  private float voteAverage;
  private int voteCount;
  private String releaseDate;
  public Movie(@JsonProperty("original_title") String name,
      @JsonProperty("poster_path") String image, @JsonProperty("vote_average") float voteAverage,
      @JsonProperty("vote_count") int voteCount, @JsonProperty("release_date") String releaseDate) {
    this.names = name;
    this.image = image;
    this.voteAverage = voteAverage;
    this.voteCount = voteCount;
    this.releaseDate = releaseDate;
  }

  public String getName() {
    return this.names;
  }

  public String getImage() {
    return this.image;
  }

  public float getVoteAverage() {
    return this.voteAverage;
  }

  public int getVoteCount() {
    return this.voteCount;
  }

  public String getReleaseDate() {
    return this.releaseDate;
  }
}
