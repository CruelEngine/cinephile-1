package com.example.newsletter;

import com.example.Subscriber;
import io.micronaut.context.annotation.Bean;
import java.util.Optional;

@Bean
public class NewsletterService {

  private SubscriberRepository subscriberRepository;

  public NewsletterService(SubscriberRepository subscriberRepository) {
    this.subscriberRepository = subscriberRepository;
  }

  public Subscriber save(Subscriber subscriber) {
    return subscriberRepository.save(subscriber);
  }

  public Optional<Subscriber> get(Long id) {
    return subscriberRepository.findById(id);
  }
}
