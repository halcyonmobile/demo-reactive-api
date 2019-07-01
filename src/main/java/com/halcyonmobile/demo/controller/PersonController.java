package com.halcyonmobile.demo.controller;

import com.halcyonmobile.demo.dto.PersonCreationDto;
import com.halcyonmobile.demo.dto.PersonDto;
import com.halcyonmobile.demo.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.halcyonmobile.demo.utils.APIUtils.BASE_API_PATH;

@RestController
@RequestMapping(BASE_API_PATH + "/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PersonDto> create(@RequestBody final Mono<PersonCreationDto> personCreation) {
        return personCreation.flatMap(personService::create);
    }

    @GetMapping("/{id}")
    public Mono<PersonDto> get(@PathVariable final String id) {
        return personService.get(id);
    }

    @PutMapping("/{id}")
    public Mono<PersonDto> update(@PathVariable final String id, @RequestBody final Mono<PersonCreationDto> personCreation) {
        return personCreation.flatMap(dto -> personService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable final String id) {
        return personService.delete(id);
    }

    @GetMapping
    public Flux<PersonDto> getAll() {
        return personService.getAll();
    }

}
