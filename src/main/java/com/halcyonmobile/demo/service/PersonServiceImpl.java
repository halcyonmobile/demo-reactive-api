package com.halcyonmobile.demo.service;

import com.halcyonmobile.demo.dto.PersonCreationDto;
import com.halcyonmobile.demo.dto.PersonDto;
import com.halcyonmobile.demo.exception.ResourceNotFoundException;
import com.halcyonmobile.demo.mapper.PersonMapper;
import com.halcyonmobile.demo.model.Person;
import com.halcyonmobile.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.halcyonmobile.demo.exception.error_type.PersonErrorType.NOT_FOUND;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(final PersonRepository personRepository, final PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Mono<PersonDto> create(final PersonCreationDto personCreation) {
        return Mono.just(personCreation)
                .map(personMapper::toEntity)
                .flatMap(personRepository::save)
                .map(personMapper::toDto);
    }

    @Override
    public Mono<PersonDto> get(final String id) {
        return personRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new ResourceNotFoundException("Person not found for id " + id, NOT_FOUND)))
                .map(personMapper::toDto);
    }

    @Override
    public Mono<PersonDto> update(final String id, final PersonCreationDto personCreation) {
        return personRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new ResourceNotFoundException("Person not found for id " + id, NOT_FOUND)))
                .map(person -> updateEntity(person, personCreation))
                .flatMap(personRepository::save)
                .map(personMapper::toDto);
    }

    @Override
    public Mono<Void> delete(final String id) {
        return personRepository.deleteById(id);
    }

    @Override
    public Flux<PersonDto> getAll() {
        return personRepository.findAll()
                .map(personMapper::toDto);
    }

    private Person updateEntity(final Person person, final PersonCreationDto personCreationDto) {
        person.setFirstName(personCreationDto.getFirstName());
        person.setLastName(personCreationDto.getLastName());
        person.setAge(personCreationDto.getAge());
        return person;
    }

}
