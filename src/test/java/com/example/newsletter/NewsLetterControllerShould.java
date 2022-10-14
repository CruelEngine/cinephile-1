package com.example.newsletter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.example.Subscriber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NewsLetterControllerShould {


  @Test
  @DisplayName("subscribe should invoke subscriber service")
  public void subscribe_should_invoke_subscriber_service() {
    NewsletterService newsletterService = mock(NewsletterService.class);
    Subscriber subscriber = new Subscriber (null , "a", "a@a");
    NewLetterController newLetterController = new NewLetterController(newsletterService);
    newLetterController.subscribe(subscriber);
    verify(newsletterService).save(subscriber);
  }

  @Test
  @DisplayName("get subscriber by id should invoke subscriber service")
  public void get_subscriber_by_id_should_invoke_subscriber_service() {
    NewsletterService newsletterService = mock(NewsletterService.class);
    Subscriber subscriber = new Subscriber (null , "a", "a@a");
    NewLetterController newLetterController = new NewLetterController(newsletterService);
    newLetterController.get(1L);
    verify(newsletterService).get(1L);

  }
}
