package com.halcyonmobile.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonCreationDto {

    private String firstName;
    private String lastName;
    private Integer age;

}
