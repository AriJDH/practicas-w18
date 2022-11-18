package com.example.BE_java_hisp_w18_g04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserBuyer extends User {
    private List<UserSeller> followed;
}
