package com.example;

public class Response {

  public String getName() {
    return name;
  }

  public String getMessage() {
    return message;
  }

  private String name;

  public Response(String name, String message) {
    this.name = name;
    this.message = message;
  }

  public Response(){}
  String message;
}
