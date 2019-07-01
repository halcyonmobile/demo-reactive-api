package com.halcyonmobile.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "persons")
public class Person {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Integer age;

}
