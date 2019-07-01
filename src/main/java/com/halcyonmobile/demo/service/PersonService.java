package com.halcyonmobile.demo.service;

import com.halcyonmobile.demo.dto.PersonCreationDto;
import com.halcyonmobile.demo.dto.PersonDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    Mono<PersonDto> create(PersonCreationDto personCreation);

    Mono<PersonDto> get(String id);

    Mono<PersonDto> update(String id, PersonCreationDto personCreation);

    Mono<Void> delete(String id);

    Flux<PersonDto> getAll();

}
