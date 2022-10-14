package com.example.newsletter;

import com.example.Subscriber;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import java.util.Optional;

@Controller("newsLetter")
public class NewLetterController {

  private NewsletterService newsletterService;

  public NewLetterController(NewsletterService newsletterService) {
    this.newsletterService = newsletterService;
  }

  @Post("subscribe")
  public Subscriber subscribe(@Body Subscriber subscriber) {
    return newsletterService.save(subscriber);
  }

  @Get("subscribers/{id}")
  public Optional<Subscriber> get(Long id) {
    return newsletterService.get(id);
  }
}
