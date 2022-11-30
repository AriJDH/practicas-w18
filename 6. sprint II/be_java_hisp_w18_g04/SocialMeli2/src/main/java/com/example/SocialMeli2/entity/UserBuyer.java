package com.example.SocialMeli2.entity;

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
