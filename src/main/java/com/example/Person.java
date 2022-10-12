package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

  private String id;
  private String name;
  public Person(@JsonProperty("id") String id, @JsonProperty("name") String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
