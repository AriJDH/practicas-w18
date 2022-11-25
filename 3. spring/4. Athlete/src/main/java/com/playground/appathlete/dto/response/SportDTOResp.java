package com.playground.appathlete.dto.response;

import com.playground.appathlete.repository.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SportDTOResp {
    private String name;
    private Level level;
}
