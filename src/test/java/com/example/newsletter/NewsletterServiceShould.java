package com.example.newsletter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.example.Subscriber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NewsletterServiceShould {

  @Test
  @DisplayName("save subscriber calls repository")
  public void save_subscriber_calls_repository() {
    SubscriberRepository subscriberRepository = mock(SubscriberRepository.class);
    NewsletterService newsletterService = new NewsletterService(subscriberRepository);
    Subscriber subscriber = new Subscriber(null, "a", "a@a");
    newsletterService.save(subscriber);
    verify(subscriberRepository).save(subscriber);
  }

  @Test
  @DisplayName("get subscriber calls respository")
  public void get_subscriber_calls_respository() {
    SubscriberRepository subscriberRepository = mock(SubscriberRepository.class);
    NewsletterService newsletterService = new NewsletterService(subscriberRepository);
    newsletterService.get(1L);
    verify(subscriberRepository).findById(1L);
  }
}