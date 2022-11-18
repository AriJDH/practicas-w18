package com.playground.appathlete.entity;

import com.playground.appathlete.repository.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sport {
    private String name;
    private Level level;
}
