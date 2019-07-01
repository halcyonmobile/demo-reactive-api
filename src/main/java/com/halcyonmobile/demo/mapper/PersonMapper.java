package com.halcyonmobile.demo.mapper;

import com.halcyonmobile.demo.dto.PersonCreationDto;
import com.halcyonmobile.demo.dto.PersonDto;
import com.halcyonmobile.demo.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person toEntity(final PersonCreationDto dto) {
        return Person.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge()).build();
    }

    public PersonDto toDto(final Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .age(person.getAge()).build();
    }

}
