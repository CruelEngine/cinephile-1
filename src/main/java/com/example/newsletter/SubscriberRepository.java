package com.example.newsletter;

import com.example.Subscriber;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {

}
