package com.halcyonmobile.demo.repository;

import com.halcyonmobile.demo.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
}
