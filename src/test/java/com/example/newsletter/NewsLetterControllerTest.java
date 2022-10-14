package com.example.newsletter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.example.Subscriber;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@MicronautTest
public class NewsLetterControllerTest {

  @Inject
  @Client("/newsLetter")
  HttpClient client;

  @Test
  @DisplayName("should save subscriber information")
  public void should_save_subscriber_information() {
    Subscriber subscriber = new Subscriber(null, "john", "john@abc.com");
    Subscriber subscriberResponse = client.toBlocking()
        .retrieve(HttpRequest.POST("subscribe", subscriber), Subscriber.class);
    Long id = subscriberResponse.getId();
    assertThat(subscriberResponse.getId()).isGreaterThan(0);
    assertThat(subscriberResponse.getFirstName()).isEqualTo("john");
    assertThat(subscriberResponse.getEmail()).isEqualTo("john@abc.com");

    subscriberResponse = client.toBlocking()
        .retrieve(HttpRequest.GET("subscribers/" + id), Subscriber.class);
    assertThat(subscriberResponse.getId()).isEqualTo(id);
    assertThat(subscriberResponse.getFirstName()).isEqualTo("john");
    assertThat(subscriberResponse.getEmail()).isEqualTo("john@abc.com");
 }
}
