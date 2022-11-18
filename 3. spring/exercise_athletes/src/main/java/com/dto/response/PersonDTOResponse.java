package com.dto.response;

import com.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonDTOResponse {
    private String name;
    private String lastName;
    private int age;
  
}
